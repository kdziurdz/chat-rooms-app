package com.grape.chat.chatapp.config;

import io.jsonwebtoken.Jwts;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.messaging.support.MessageHeaderAccessor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

import java.util.ArrayList;
import java.util.List;

import static com.grape.chat.chatapp.config.SecurityConstants.TOKEN_PREFIX;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic");
        config.setApplicationDestinationPrefixes("/ws-api");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry
                .addEndpoint("/ws")
                .setAllowedOrigins("*")
                .withSockJS(); // websocket
    }

    @Override
    public void configureClientInboundChannel(ChannelRegistration registration) {
        int i = 1;
        System.out.println("XXX");
        registration.interceptors(new CustomChannelInterceptor());
    }

    //    @Override
//    public void configureClientInboundChannel(ChannelRegistration registration) {
//        registration.interceptors(new CustomChannelInterceptor());
//    }
//
    private class CustomChannelInterceptor implements ChannelInterceptor {
        @Override
        public Message<?> preSend(Message<?> message, MessageChannel channel) {
            StompHeaderAccessor accessor =
                    MessageHeaderAccessor.getAccessor(message, StompHeaderAccessor.class);
            final StompCommand command = accessor.getCommand();

            LinkedMultiValueMap<String, String> headers = (LinkedMultiValueMap<String, String>) accessor.getHeader("nativeHeaders");
            final List<String> tokenList = headers.get("Authorization");

            if (tokenList == null || tokenList.isEmpty()) {
                throw new AccessDeniedException("No Authorization token provided in STOMP message");

            }

            String token = tokenList.get(0);

            String userParsed = Jwts.parser()
                    .setSigningKey(SecurityConstants.SECRET.getBytes())
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .getBody()
                    .getSubject();

            if (StompCommand.CONNECT.equals(command) || StompCommand.MESSAGE.equals(command)) {
                Authentication user
                        = new UsernamePasswordAuthenticationToken(userParsed, null, new ArrayList<>());
                accessor.setUser(user);
            }
            return message;
        }
    }
}
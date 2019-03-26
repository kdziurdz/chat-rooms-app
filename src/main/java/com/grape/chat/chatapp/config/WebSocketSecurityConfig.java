package com.grape.chat.chatapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.messaging.MessageSecurityMetadataSourceRegistry;
import org.springframework.security.config.annotation.web.socket.AbstractSecurityWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
public class WebSocketSecurityConfig
        extends AbstractSecurityWebSocketMessageBrokerConfigurer {
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        super.registerStompEndpoints(registry);
    }

//    protected void configureInbound(MessageSecurityMetadataSourceRegistry messages) {
//        messages
//                .simpDestMatchers("**").permitAll()
//                .anyMessage().permitAll()
//                .anyMessage().authenticated();
//    }

    @Override
    protected void configureInbound(MessageSecurityMetadataSourceRegistry message) {
        message
//                .nullDestMatcher().permitAll()
//                .simpDestMatchers("**").permitAll()
                .anyMessage().permitAll();
//                .anyMessage().authenticated();
    }



    @Override
    protected boolean sameOriginDisabled() {
        return true;
    }
}

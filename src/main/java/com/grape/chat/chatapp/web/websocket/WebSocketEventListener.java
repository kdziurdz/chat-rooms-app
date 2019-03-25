package com.grape.chat.chatapp.web.websocket;

import com.grape.chat.chatapp.dto.message.ChatMessageParticipantsDTO;
import com.grape.chat.chatapp.dto.message.ChatMessageSnapshotDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;
import org.springframework.web.socket.messaging.SessionSubscribeEvent;

@Component
public class WebSocketEventListener {
    private static final Logger logger = LoggerFactory.getLogger(WebSocketEventListener.class);

    @Autowired
    private SimpMessageSendingOperations messagingTemplate;

    @EventListener
    public void handleWebSocketConnectListener(SessionConnectedEvent event) {
        logger.info("Received a new web socket connection");
    }

    @EventListener
    public void handleWebSocketConnectListener(SessionSubscribeEvent event) {
        final Object topic = event.getMessage().getHeaders().get("simpDestination").toString();

        // do wszystkich, że nowy subskryber new ChatMessageParticipantsDTO()
        // do jednego INIT

        logger.info("NEW SUBSCRIPTION!!!!");
    }

    @EventListener
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
//        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
//
//        String username = (String) headerAccessor.getSessionAttributes().get("username");
//        if (username != null) {
//            logger.info("User Disconnected : " + username);
//
//            ChatMessageSnapshotDTO chatMessage = new ChatMessageSnapshotDTO();
//            chatMessage.setType(ChatMessageSnapshotDTO.Type.LEAVE);
//            chatMessage.setSender(username);
//
//            messagingTemplate.convertAndSend("/topic/public", chatMessage);
//        }
    }
}

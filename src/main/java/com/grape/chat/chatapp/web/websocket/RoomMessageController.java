package com.grape.chat.chatapp.web.websocket;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import java.time.Instant;

@Controller
public class RoomMessageController {

    @MessageMapping("/message")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload IncomingMessage incomingMessage,
                                   SimpMessageHeaderAccessor headerAccessor) {
        return getChatMessage(incomingMessage, headerAccessor);
    }

    @MessageMapping("/add-user")
    @SendTo("/topic/public")
    public void addUser(@Payload IncomingMessage incomingMessage, // TODO broadcast user added
                        SimpMessageHeaderAccessor headerAccessor) {
        headerAccessor.getSessionAttributes().put("username", incomingMessage.getPlainText());
        // return chatMessage;
    }

    ////////////////////////////////////////////////////////////


    @MessageMapping("/topic/room.{roomId}.message")
    @SendTo("/topic/room.{roomId}")
    public ChatMessage sendMessageToRoom(@Payload IncomingMessage incomingMessage,
                                         @DestinationVariable String roomId,
                                   SimpMessageHeaderAccessor headerAccessor) {
        return getChatMessage(incomingMessage, headerAccessor);
    }

    private ChatMessage getChatMessage(@Payload IncomingMessage incomingMessage, SimpMessageHeaderAccessor headerAccessor) {
        final ChatMessage chatMessage = new ChatMessage();
        chatMessage.setType(ChatMessage.Type.MESSAGE);
        chatMessage.setContent(new MessageContent.Builder()
                .authorName(headerAccessor.getSessionAttributes()
                        .get("username").toString())
                .id(headerAccessor.getSessionId())
                .message(incomingMessage.getPlainText())
                .timestamp(Instant.now().toString())
                .build()
        );
        return chatMessage;
    }

    @MessageMapping("/topic/room.{roomId}.addUser")
    @SendTo("/topic/room.{roomId}")  // TODO broadcast user added
    public void addUsertoRoom(@Payload IncomingMessage incomingMessage,
                              @DestinationVariable String roomId,
                              SimpMessageHeaderAccessor headerAccessor) {
        headerAccessor.getSessionAttributes().put("username", incomingMessage.getPlainText());
        // return chatMessage;
    }


}

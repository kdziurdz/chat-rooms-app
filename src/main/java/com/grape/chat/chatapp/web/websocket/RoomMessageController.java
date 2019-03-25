package com.grape.chat.chatapp.web.websocket;

import com.grape.chat.chatapp.dto.message.ChatMessageSnapshotDTO;
import com.grape.chat.chatapp.dto.message.NewChatMessageDTO;
import com.grape.chat.chatapp.service.MessageService;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import java.util.Map;

@Controller
public class RoomMessageController {
    private final MessageService messageService;

    public RoomMessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @MessageMapping("/topic/room.{roomId}.message")
    @SendTo("/topic/room.{roomId}")
    public NewChatMessageDTO sendMessageToRoom(@Payload IncomingMessageDTO incomingMessage,
                                               @DestinationVariable String roomId,
                                               SimpMessageHeaderAccessor headerAccessor) {

        return messageService.create(incomingMessage.getPlainText(), roomId,
                headerAccessor.getSessionAttributes().get("username").toString());
    }

    @MessageMapping("/topic/room.{roomId}.addUser")
    @SendTo("/topic/room.{roomId}")  // TODO broadcast user added
    public void addUserToRoom(@Payload IncomingMessageDTO incomingMessage,
                              @DestinationVariable String roomId,
                              SimpMessageHeaderAccessor headerAccessor) {
        final Map<String, Object> sessionAttributes = headerAccessor.getSessionAttributes();
        sessionAttributes.put("username", incomingMessage.getPlainText());
        sessionAttributes.put("roomId", roomId);
    }


}

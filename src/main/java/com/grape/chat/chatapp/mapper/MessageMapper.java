package com.grape.chat.chatapp.mapper;

import com.grape.chat.chatapp.entity.Message;
import com.grape.chat.chatapp.dto.message.MessageContentDTO;
import org.springframework.stereotype.Component;

@Component
public class MessageMapper {

    public MessageContentDTO asDTO(Message message) {
        final MessageContentDTO content = new MessageContentDTO();

        content.setAuthorName(message.getAuthorName());
        content.setId(message.getId());
        content.setMessage(message.getMessage());
        content.setTimestamp(message.getTimestamp().toString());
        content.setRoomId(message.getRoomId());

        return content;
    }
}

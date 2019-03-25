package com.grape.chat.chatapp.service;

import com.grape.chat.chatapp.dto.message.ChatMessageDTO;
import com.grape.chat.chatapp.repository.MessageRepository;
import org.springframework.stereotype.Service;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

@Service
public class MessageService {

    private final MessageRepository messageRepository;
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public ChatMessageDTO create(String givenText, String roomId, String givenUsername) {
        throw new NotImplementedException();
    }
}

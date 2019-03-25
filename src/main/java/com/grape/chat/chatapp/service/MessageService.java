package com.grape.chat.chatapp.service;

import com.grape.chat.chatapp.dto.message.ChatMessageSnapshotDTO;
import com.grape.chat.chatapp.dto.message.MessageContentDTO;
import com.grape.chat.chatapp.dto.message.NewChatMessageDTO;
import com.grape.chat.chatapp.entity.Message;
import com.grape.chat.chatapp.mapper.MessageMapper;
import com.grape.chat.chatapp.repository.MessageRepository;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private final MessageRepository messageRepository;
    private final MessageMapper messageMapper;

    public MessageService(MessageRepository messageRepository, MessageMapper messageMapper) {
        this.messageRepository = messageRepository;
        this.messageMapper = messageMapper;
    }

    public NewChatMessageDTO create(String givenText, String roomId, String givenUsername) {
        Message createdMessage = messageRepository.save(new Message(givenText, givenUsername, roomId));

        final MessageContentDTO messageContentDTO = messageMapper.asDTO(createdMessage);

        return new NewChatMessageDTO(messageContentDTO);
    }
}

package com.grape.chat.chatapp.service;

import com.grape.chat.chatapp.entity.Message;
import com.grape.chat.chatapp.repository.MessageRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.*;

class MessageServiceTest {

    @Mock
    private MessageRepository messageRepository;

    private MessageService service;
//
//    @BeforeEach
//    void setUp() {
//        service = new MessageService(messageRepository)
//    }
//
//    @Test
//    public void createMessage_shouldCallRepository() {
//        MessageDTO messageDTO = mock(MessageDTO.class);
//
//        service.createMessage(messageDTO);
//
//        verify(messageRepository, times(1)).save();
//    }
//    @Test
//    public void createMessage_shouldReturnMessageDTO() {
//
//    }
}
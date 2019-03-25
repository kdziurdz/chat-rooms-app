package com.grape.chat.chatapp.service;

import com.grape.chat.chatapp.dto.message.ChatMessageSnapshotDTO;
import com.grape.chat.chatapp.dto.message.NewChatMessageDTO;
import com.grape.chat.chatapp.entity.Message;
import com.grape.chat.chatapp.mapper.MessageMapper;
import com.grape.chat.chatapp.repository.MessageRepository;
import com.grape.chat.chatapp.dto.message.MessageContentDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class MessageServiceTest {

    @Mock
    private MessageRepository messageRepository;
    @Mock
    private MessageMapper messageMapper;

    private MessageService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        service = new MessageService(messageRepository, messageMapper);
    }

    @Test
    public void createMessage_shouldCallRepository() {
        String givenText = "givenText";
        String roomId = "roomId";
        String givenUserName = "givenUserName";

        Message createdMessage = mock(Message.class);
        when(messageRepository.save(any(Message.class))) // new Message(givenText, givenUserName, roomId)
                .thenReturn(createdMessage);

        MessageContentDTO mappedMessageContent = mock(MessageContentDTO.class);
        when(messageMapper.asDTO(createdMessage))
                .thenReturn(mappedMessageContent);

        final NewChatMessageDTO result = service.create(givenText, roomId, givenUserName);

        assertEquals(result.getContent(), Collections.singletonList(mappedMessageContent));
        assertEquals(result.getType(), ChatMessageSnapshotDTO.Type.MESSAGE);

        verify(messageRepository, times(1))
                .save(any(Message.class));
        verify(messageMapper, times(1))
                .asDTO(createdMessage);

    }

    @Test
    public void createMessage_shouldReturnMessageDTO() {

    }
}
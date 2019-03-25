package com.grape.chat.chatapp.mapper;

import com.grape.chat.chatapp.entity.Message;
import com.grape.chat.chatapp.dto.message.MessageContentDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MessageMapperTest {

    private MessageMapper messageMapper;

    @BeforeEach
    void setUp() {
        messageMapper = new MessageMapper();
    }

    @Test
    void asDTO() {
        String givenAuthorName = "givenAuthorName";
        String givenId = "givenId";
        String givenMessageText = "givenMessage";
        String givenRoomId = "givenRoomId";
        LocalDateTime givenTimestamp = LocalDateTime.of(2018, 12, 12, 10, 10);

        Message givenMessage = new Message();
        givenMessage.setAuthorName(givenAuthorName);
        givenMessage.setId(givenId);
        givenMessage.setMessage(givenMessageText);
        givenMessage.setRoomId(givenRoomId);
        givenMessage.setTimestamp(givenTimestamp);

        final MessageContentDTO result = messageMapper.asDTO(givenMessage);

        assertEquals(result.getAuthorName(), givenAuthorName);
        assertEquals(result.getId(), givenId);
        assertEquals(result.getMessage(), givenMessageText);
        assertEquals(result.getTimestamp(), givenTimestamp.toString());
        assertEquals(result.getRoomId(), givenRoomId);
    }
}
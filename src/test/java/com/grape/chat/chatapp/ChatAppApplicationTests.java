package com.grape.chat.chatapp;


import com.grape.chat.chatapp.repository.MessageRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
public class ChatAppApplicationTests {

    @MockBean
    private MessageRepository messageRepository;

    @Test
    @DisplayName("Context loads, app runs...")
    public void contextLoads() {
        assertEquals(1, 1);
    }

}

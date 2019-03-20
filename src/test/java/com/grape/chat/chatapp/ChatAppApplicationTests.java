package com.grape.chat.chatapp;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ChatAppApplicationTests {

    @Test
    @DisplayName("Context loads, app runs...")
    public void contextLoads() {
        assertEquals(1, 1);
    }

}

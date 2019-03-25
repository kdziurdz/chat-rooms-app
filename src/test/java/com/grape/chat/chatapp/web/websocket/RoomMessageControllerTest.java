package com.grape.chat.chatapp.web.websocket;

import com.grape.chat.chatapp.dto.message.ChatMessageSnapshotDTO;
import com.grape.chat.chatapp.dto.message.NewChatMessageDTO;
import com.grape.chat.chatapp.service.MessageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;

class RoomMessageControllerTest {

    @Mock
    private MessageService messageService;

    private RoomMessageController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        controller = new RoomMessageController(messageService);
    }

    @Test
    void sendMessageToRoom_shouldCallServiceAndReturnChatMessageDTO() {
        String givenText = "givenText";
        String roomId = "roomId";
        IncomingMessageDTO incomingMessage = new IncomingMessageDTO(givenText);

        SimpMessageHeaderAccessor headerAccessor = mock(SimpMessageHeaderAccessor.class);
        String givenUsername = "user";
        Map<String, Object> givenSessionAttrs = Collections.singletonMap("username", givenUsername);
        when(headerAccessor.getSessionAttributes()).thenReturn(givenSessionAttrs);

        NewChatMessageDTO returnedChatMessage = mock(NewChatMessageDTO.class);
        when(messageService.create(givenText, roomId, givenUsername)).thenReturn(returnedChatMessage);

        final NewChatMessageDTO result = controller
                .sendMessageToRoom(incomingMessage, roomId, headerAccessor);

        verify(headerAccessor, times(1)).getSessionAttributes();
        verify(messageService, times(1)).create(givenText, roomId, givenUsername);
        assertEquals(result, returnedChatMessage);

        verifyNoMoreInteractions(messageService);
        verifyNoMoreInteractions(headerAccessor);
    }

    @Test
    void addUserToRoom_shouldSetSessionAttributes() {
        String givenText = "givenText";
        String roomId = "roomId";
        IncomingMessageDTO incomingMessage = new IncomingMessageDTO(givenText);

        SimpMessageHeaderAccessor headerAccessor = mock(SimpMessageHeaderAccessor.class);
        Map<String, Object> givenSessionAttrs = new HashMap<>();
        when(headerAccessor.getSessionAttributes()).thenReturn(givenSessionAttrs);

        controller.addUserToRoom(incomingMessage, roomId, headerAccessor);

        verify(headerAccessor, times(1)).getSessionAttributes();
        assertEquals(givenSessionAttrs.get("username"), givenText);
        assertEquals(givenSessionAttrs.get("roomId"), roomId);
    }
}
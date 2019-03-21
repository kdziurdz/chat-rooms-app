package com.grape.chat.chatapp.mapper;

import com.grape.chat.chatapp.dto.rooms.RoomDTO;
import com.grape.chat.chatapp.entity.Room;
import org.springframework.stereotype.Component;

@Component
public class RoomDTOMapper {
    public RoomDTO asDTO(Room room) {
        return new RoomDTO(room.getName(), room.getPasswordHash() != null, room.getId());
    }
}

package com.grape.chat.chatapp.service;

import com.grape.chat.chatapp.dto.rooms.CreateRoomDTO;
import com.grape.chat.chatapp.dto.rooms.RoomDTO;
import com.grape.chat.chatapp.entity.Room;
import com.grape.chat.chatapp.mapper.RoomDTOMapper;
import com.grape.chat.chatapp.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoomService {
    private final RoomRepository roomRepository;
    private final PasswordHasher passwordHasher;
    private final RoomDTOMapper roomDTOMapper;

    public RoomService(RoomRepository roomRepository, PasswordHasher passwordHasher, RoomDTOMapper roomDTOMapper) {
        this.roomRepository = roomRepository;
        this.passwordHasher = passwordHasher;
        this.roomDTOMapper = roomDTOMapper;
    }

    public List<RoomDTO> getAll() {
        return roomRepository
                .findAll().stream()
                .map(roomDTOMapper::asDTO)
                .collect(Collectors.toList());
    }

    public RoomDTO createRoom(CreateRoomDTO createRoomDTO) {
        final Optional<String> password = Optional.ofNullable(createRoomDTO.getPassword());
        Room room;

        room = password
                .map(passwordText -> new Room(createRoomDTO.getName(), passwordHasher.hash(passwordText)))
                .orElseGet(() -> new Room(createRoomDTO.getName()));
        final Room createdRoom = roomRepository.save(room);
        return roomDTOMapper.asDTO(createdRoom);
    }

    public List<RoomDTO> getAllByName(String name) {
        return roomRepository.findAllByName(name).stream().map(roomDTOMapper::asDTO).collect(Collectors.toList());
    }
}

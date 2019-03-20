package com.grape.chat.chatapp.rest.rooms;

import com.grape.chat.chatapp.entity.Room;
import com.grape.chat.chatapp.repository.RoomRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController()
@RequestMapping("api/1/rooms")
public class RoomsController {
    private final RoomRepository roomRepository;

    public RoomsController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @GetMapping("/")
    public ResponseEntity<List<Room>> get() {


        return new ResponseEntity<>(roomRepository.findAll(), HttpStatus.OK);
    }
    @PostMapping("/")
    public void create(@RequestBody @Valid CreateRoomDTO createRoomDTO) {

        Room room = new Room(createRoomDTO.getName());
        roomRepository.save(room);
    }
}

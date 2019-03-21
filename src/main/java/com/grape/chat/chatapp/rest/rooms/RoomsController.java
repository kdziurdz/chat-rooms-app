package com.grape.chat.chatapp.rest.rooms;

import com.grape.chat.chatapp.dto.rooms.CreateRoomDTO;
import com.grape.chat.chatapp.dto.rooms.RoomDTO;
import com.grape.chat.chatapp.service.RoomService;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController()
@RequestMapping("api/1/rooms")
public class RoomsController {
    private final RoomService roomService;

    public RoomsController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public ResponseEntity<List<RoomDTO>> get() {
        return new ResponseEntity<>(roomService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<RoomDTO>> search(@RequestParam String name) {
        return new ResponseEntity<>(roomService.getAllByName(name), HttpStatus.OK);
    }

    @PostMapping
    public RoomDTO create(@RequestBody @Valid CreateRoomDTO createRoomDTO) {
        return roomService.createRoom(createRoomDTO);
    }

    @GetMapping("/{roomId}")
    public ResponseEntity<List<RoomDTO>> authorize(@PathVariable String roomId) {
        throw new NotImplementedException("not implemented yet", roomId);
    }
}

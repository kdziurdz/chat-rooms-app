package com.grape.chat.chatapp.web.rest.messages;

import com.grape.chat.chatapp.entity.Message;
import com.grape.chat.chatapp.repository.MessageRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController()
@RequestMapping("api/1/messages")
public class MessageController {
    private final MessageRepository messageRepository;

    public MessageController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @GetMapping("/")
    public ResponseEntity<Page<Message>> get() {

        Page<Message> all = messageRepository.findAll(PageRequest.of(0, 100));
        return new ResponseEntity<>(all, HttpStatus.OK);
    }
    @PostMapping("/")
    public void create(@RequestBody @Valid CreateMessageDTO createMessageDTO) {

        Message message = new Message(createMessageDTO.getText());
        messageRepository.save(message);
    }
}

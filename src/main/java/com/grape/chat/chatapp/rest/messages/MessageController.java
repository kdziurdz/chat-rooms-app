package com.grape.chat.chatapp.rest.messages;

import com.grape.chat.chatapp.entity.Customer;
import com.grape.chat.chatapp.entity.Room;
import com.grape.chat.chatapp.repository.CustomerRepository;
import com.grape.chat.chatapp.repository.RoomRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController()
@RequestMapping("api/1/messages")
public class MessageController {
    private final CustomerRepository customerRepository;

    public MessageController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/")
    public ResponseEntity<List<Customer>> get() {


        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }
    @PostMapping("/")
    public void create(@RequestBody @Valid CreateMessageDTO createMessageDTO) {

        Customer customer = new Customer(createMessageDTO.getText(), "nazwisko");
        customerRepository.save(customer);
    }
}

package com.grape.chat.chatapp.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("api/1/sample")
public class ExchangeRateSummaryController {

    @GetMapping("/")
    public ResponseEntity<String> get() {
        return new ResponseEntity<>("SIEMA", HttpStatus.OK);
    }
}

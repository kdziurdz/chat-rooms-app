package com.grape.chat.chatapp.service;

import org.springframework.stereotype.Service;

@Service
public class PasswordHasher { // TODO implement encryptor

    public String hash(String password) {
        return password + "hashed";
    }

    public Boolean check(String passwordText, String hashed) {
        return hash(passwordText).equals(hashed);
    }
}

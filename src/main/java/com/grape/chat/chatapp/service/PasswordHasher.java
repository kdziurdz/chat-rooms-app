package com.grape.chat.chatapp.service;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class PasswordHasher {
    private static final String SALT = BCrypt.gensalt(10);

    public String hash(String password) {
        return BCrypt.hashpw(password, SALT);
    }

    public Boolean check(String passwordText, String hashed) {
        return BCrypt.checkpw(passwordText, hashed);
    }
}

package com.grape.chat.chatapp.entity;

import org.springframework.data.annotation.Id;

public class Room {
    @Id
    public String id;

    public String name;


    public Room(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

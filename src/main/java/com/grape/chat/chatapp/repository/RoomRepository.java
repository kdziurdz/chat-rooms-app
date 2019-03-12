package com.grape.chat.chatapp.repository;

import com.grape.chat.chatapp.entity.Room;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RoomRepository extends MongoRepository<Room, String> {

    public Room findByName(String firstName);
    public List<Room> findAll();

}
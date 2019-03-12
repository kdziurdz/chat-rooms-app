package com.grape.chat.chatapp.rest;

import javax.validation.constraints.NotBlank;

public class CreateRoomDTO {
    @NotBlank
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

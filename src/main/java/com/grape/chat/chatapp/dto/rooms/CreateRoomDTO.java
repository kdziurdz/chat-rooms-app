package com.grape.chat.chatapp.dto.rooms;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.validation.constraints.NotBlank;

public class CreateRoomDTO extends BaseRoom {

    private String password;

    public CreateRoomDTO(@NotBlank String name, String password) {
        super(name);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append("password", password)
                .toString();
    }
}

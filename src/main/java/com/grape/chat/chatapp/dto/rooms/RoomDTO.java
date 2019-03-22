package com.grape.chat.chatapp.dto.rooms;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class RoomDTO extends BaseRoom {
    @NotNull
    private Boolean hasPassword;

    @NotNull
    private String id;

    public RoomDTO(String name, Boolean hasPassword, String id) {
        super(name);
        this.hasPassword = hasPassword;
        this.id = id;
    }

    public Boolean getHasPassword() {
        return hasPassword;
    }

    public void setHasPassword(Boolean hasPassword) {
        this.hasPassword = hasPassword;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append("hasPassword", hasPassword)
                .toString();
    }
}

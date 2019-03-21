package com.grape.chat.chatapp.dto.rooms;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.validation.constraints.NotBlank;

abstract class BaseRoom {

    BaseRoom(@NotBlank String name) {
        this.name = name;
    }

    @NotBlank
    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("name", name)
                .toString();
    }
}

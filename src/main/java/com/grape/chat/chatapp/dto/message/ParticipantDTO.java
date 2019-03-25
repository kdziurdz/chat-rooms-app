package com.grape.chat.chatapp.dto.message;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class ParticipantDTO {
    private String id;
    private String username;

    public ParticipantDTO(String id, String username) {
        this.id = id;
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("username", username)
                .toString();
    }
}

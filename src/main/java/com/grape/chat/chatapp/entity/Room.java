package com.grape.chat.chatapp.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Room {
    @Id
    private String id;

    @NotBlank
    private String name;

    @NotNull
    private String passwordHash;

    public Room(String name, String passwordHash) {
        this.name = name;
        this.passwordHash = passwordHash;
    }

    public Room(String name) {
        this.name = name;
    }

    protected Room() {
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    @Override
    public String toString() {
        return new org.apache.commons.lang3.builder.ToStringBuilder(this)
                .append("id", id)
                .append("name", name)
                .append("passwordHash", passwordHash)
                .toString();
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Room room = (Room) o;

        return new EqualsBuilder()
                .append(id, room.id)
                .append(name, room.name)
                .append(passwordHash, room.passwordHash)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(name)
                .append(passwordHash)
                .toHashCode();
    }
}

package com.grape.chat.chatapp.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.data.annotation.Id;

public class Room {
    @Id
    private String id;

    private String name;

    private Boolean hasPassword;

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

    public Boolean getHasPassword() {
        return hasPassword;
    }

    @Override
    public String toString() {
        return new org.apache.commons.lang3.builder.ToStringBuilder(this)
                .append("id", id)
                .append("name", name)
                .append("hasPassword", hasPassword)
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
                .append(hasPassword, room.hasPassword)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(name)
                .append(hasPassword)
                .toHashCode();
    }
}

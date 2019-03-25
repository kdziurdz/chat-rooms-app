package com.grape.chat.chatapp.dto.message;

import org.apache.commons.lang3.builder.ToStringBuilder;

public abstract class AbstractChatMessageDTO {
    private Type type;

    public enum Type {
        MESSAGE,
        INIT,
        USER_JOINED
    }

    AbstractChatMessageDTO(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("type", type)
                .toString();
    }
}
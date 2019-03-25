package com.grape.chat.chatapp.web.websocket;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class ChatMessage {
    private Type type;
    private MessageContent content;

    public enum Type {
        MESSAGE,
        INIT
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public MessageContent getContent() {
        return content;
    }

    public void setContent(MessageContent content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("type", type)
                .append("content", content)
                .toString();
    }
}
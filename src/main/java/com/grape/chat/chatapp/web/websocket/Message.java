package com.grape.chat.chatapp.web.websocket;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Message {

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Message(String content) {
        this.content = content;
    }

    public Message() {
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("content", content)
                .toString();
    }
}

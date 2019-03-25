package com.grape.chat.chatapp.web.websocket;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class MessageContent {
    private String id;
    private String message;
    private String timestamp;
    private String authorName;

    private MessageContent(Builder builder) {
        setId(builder.id);
        setMessage(builder.message);
        setTimestamp(builder.timestamp);
        setAuthorName(builder.authorName);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("message", message)
                .append("timestamp", timestamp)
                .append("authorName", authorName)
                .toString();
    }

    public static final class Builder {
        private String id;
        private String message;
        private String timestamp;
        private String authorName;

        public Builder() {
        }

        public Builder id(String val) {
            id = val;
            return this;
        }

        public Builder message(String val) {
            message = val;
            return this;
        }

        public Builder timestamp(String val) {
            timestamp = val;
            return this;
        }

        public Builder authorName(String val) {
            authorName = val;
            return this;
        }

        public MessageContent build() {
            return new MessageContent(this);
        }
    }
}

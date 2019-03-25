package com.grape.chat.chatapp.web.websocket;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class IncomingMessage {
    private String plainText;

    public String getPlainText() {
        return plainText;
    }

    public void setPlainText(String plainText) {
        this.plainText = plainText;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("plainText", plainText)
                .toString();
    }
}

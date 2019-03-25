package com.grape.chat.chatapp.dto.message;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class IncomingMessageDTO {
    private String plainText;

    public IncomingMessageDTO(String plainText) {
        this.plainText = plainText;
    }

    public IncomingMessageDTO() {
    }

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

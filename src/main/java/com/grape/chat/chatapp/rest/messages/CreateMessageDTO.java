package com.grape.chat.chatapp.rest.messages;

import javax.validation.constraints.NotBlank;

public class CreateMessageDTO {
    @NotBlank
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

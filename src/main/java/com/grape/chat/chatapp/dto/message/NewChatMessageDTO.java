package com.grape.chat.chatapp.dto.message;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NewChatMessageDTO extends AbstractChatMessageDTO {
    private List<MessageContentDTO> content = new ArrayList<>();

    public NewChatMessageDTO(MessageContentDTO messageContentDTO) {
        super(Type.MESSAGE);
        this.content = Collections.singletonList(messageContentDTO);
    }

    public NewChatMessageDTO() {
        super(Type.MESSAGE);
    }

    public List<MessageContentDTO> getContent() {
        return content;
    }

    public void setContent(List<MessageContentDTO> content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append("content", content)
                .toString();
    }
}
package com.grape.chat.chatapp.dto.message;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;

public class ChatMessageSnapshotDTO extends AbstractChatMessageDTO {
    private List<MessageContentDTO> content = new ArrayList<>();
    private List<ParticipantDTO> participants = new ArrayList<>();

    public ChatMessageSnapshotDTO(List<MessageContentDTO> content,
                                  List<ParticipantDTO> participants) {
        super(Type.INIT);
        this.content = content;
        this.participants = participants;
    }

    public ChatMessageSnapshotDTO() {
        super(Type.INIT);
    }

    public List<MessageContentDTO> getContent() {
        return content;
    }

    public void setContent(List<MessageContentDTO> content) {
        this.content = content;
    }

    public List<ParticipantDTO> getParticipants() {
        return participants;
    }

    public void setParticipants(List<ParticipantDTO> participants) {
        this.participants = participants;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append("content", content)
                .toString();
    }
}
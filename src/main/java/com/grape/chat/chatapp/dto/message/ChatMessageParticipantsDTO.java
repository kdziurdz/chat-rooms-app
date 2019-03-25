package com.grape.chat.chatapp.dto.message;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;

public class ChatMessageParticipantsDTO extends AbstractChatMessageDTO {

    private List<ParticipantDTO> participants = new ArrayList<>();

    public ChatMessageParticipantsDTO(Type type) {
        super(type);
    }

    public ChatMessageParticipantsDTO(Type type, List<ParticipantDTO> participants) {
        super(type);
        this.participants = participants;
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
                .append("participants", participants)
                .toString();
    }
}

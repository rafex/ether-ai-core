package dev.rafex.ether.ai.core.chat;

import java.util.Objects;

import dev.rafex.ether.ai.core.message.AiMessage;
import dev.rafex.ether.ai.core.usage.AiUsage;

public record AiChatResponse(String id, String model, AiMessage message, String finishReason, AiUsage usage) {

    public AiChatResponse {
        id = id == null ? "" : id;
        model = model == null ? "" : model;
        finishReason = finishReason == null ? "" : finishReason;
        Objects.requireNonNull(message, "message");
        usage = usage == null ? AiUsage.empty() : usage;
    }

    public String text() {
        return message.content();
    }
}

package dev.rafex.ether.ai.core.chat;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import dev.rafex.ether.ai.core.message.AiMessage;

public record AiChatRequest(String model, List<AiMessage> messages, Double temperature, Integer maxOutputTokens) {

    public AiChatRequest {
        Objects.requireNonNull(model, "model");
        if (model.isBlank()) {
            throw new IllegalArgumentException("model must not be blank");
        }
        Objects.requireNonNull(messages, "messages");
        if (messages.isEmpty()) {
            throw new IllegalArgumentException("messages must not be empty");
        }
        messages = List.copyOf(messages);
        if (temperature != null && (temperature < 0.0d || temperature > 2.0d)) {
            throw new IllegalArgumentException("temperature must be between 0.0 and 2.0");
        }
        if (maxOutputTokens != null && maxOutputTokens < 1) {
            throw new IllegalArgumentException("maxOutputTokens must be greater than 0");
        }
    }

    public static AiChatRequest of(final String model, final AiMessage... messages) {
        return new AiChatRequest(model, Arrays.asList(messages), null, null);
    }
}

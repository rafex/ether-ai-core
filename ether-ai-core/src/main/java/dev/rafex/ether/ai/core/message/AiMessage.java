package dev.rafex.ether.ai.core.message;

import java.util.Objects;

public record AiMessage(AiMessageRole role, String content) {

    public AiMessage {
        Objects.requireNonNull(role, "role");
        Objects.requireNonNull(content, "content");
        if (content.isBlank()) {
            throw new IllegalArgumentException("content must not be blank");
        }
    }

    public static AiMessage system(final String content) {
        return new AiMessage(AiMessageRole.SYSTEM, content);
    }

    public static AiMessage user(final String content) {
        return new AiMessage(AiMessageRole.USER, content);
    }

    public static AiMessage assistant(final String content) {
        return new AiMessage(AiMessageRole.ASSISTANT, content);
    }
}

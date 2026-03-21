package dev.rafex.ether.ai.core.usage;

public record AiUsage(int inputTokens, int outputTokens, int totalTokens) {

    public AiUsage {
        if (inputTokens < 0 || outputTokens < 0 || totalTokens < 0) {
            throw new IllegalArgumentException("usage tokens must be non-negative");
        }
    }

    public static AiUsage empty() {
        return new AiUsage(0, 0, 0);
    }
}

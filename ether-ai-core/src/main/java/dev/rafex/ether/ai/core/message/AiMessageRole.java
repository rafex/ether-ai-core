package dev.rafex.ether.ai.core.message;

public enum AiMessageRole {
    SYSTEM("system"),
    USER("user"),
    ASSISTANT("assistant"),
    TOOL("tool");

    private final String wireValue;

    AiMessageRole(final String wireValue) {
        this.wireValue = wireValue;
    }

    public String wireValue() {
        return wireValue;
    }

    public static AiMessageRole fromWireValue(final String value) {
        if (value == null || value.isBlank()) {
            return ASSISTANT;
        }
        for (final var role : values()) {
            if (role.wireValue.equalsIgnoreCase(value)) {
                return role;
            }
        }
        throw new IllegalArgumentException("Unsupported role: " + value);
    }
}

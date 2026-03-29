package dev.rafex.ether.ai.core.message;

/**
 * Define los roles posibles para los mensajes en una conversación de IA.
 */
public enum AiMessageRole {
    /** Rol del sistema para instrucciones de fondo. */
    SYSTEM("system"),
    /** Rol del usuario que hace preguntas. */
    USER("user"),
    /** Rol del asistente que responde. */
    ASSISTANT("assistant"),
    /** Rol de herramienta/function calling. */
    TOOL("tool");

    private final String wireValue;

    AiMessageRole(final String wireValue) {
        this.wireValue = wireValue;
    }

    /**
     * Devuelve el valor utilizado en la serialización (formato de la API).
     *
     * @return El valor de serialización.
     */
    public String wireValue() {
        return wireValue;
    }

    /**
     * Convierte un valor de la API al enum correspondiente.
     *
     * @param value El valor de la API.
     * @return El enum correspondiente, o ASSISTANT si es nulo o vacío.
     * @throws IllegalArgumentException si el valor no es soportado.
     */
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

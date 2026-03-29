package dev.rafex.ether.ai.core.message;

import java.util.Objects;

/**
 * Mensaje en una conversación con un modelo de IA.
 *
 * @param role    El rol del remitente del mensaje.
 * @param content El contenido textual del mensaje.
 */
public record AiMessage(AiMessageRole role, String content) {

    /**
     * Crea un nuevo mensaje y valida los parámetros.
     *
     * @param role    El rol del remitente del mensaje.
     * @param content El contenido textual del mensaje.
     * @throws NullPointerException     si el rol o el contenido son nulos.
     * @throws IllegalArgumentException si el contenido está en blanco.
     */
    public AiMessage {
        Objects.requireNonNull(role, "role");
        Objects.requireNonNull(content, "content");
        if (content.isBlank()) {
            throw new IllegalArgumentException("content must not be blank");
        }
    }

    /**
     * Crea un mensaje de sistema.
     *
     * @param content El contenido del mensaje.
     * @return El mensaje creado.
     */
    public static AiMessage system(final String content) {
        return new AiMessage(AiMessageRole.SYSTEM, content);
    }

    /**
     * Crea un mensaje de usuario.
     *
     * @param content El contenido del mensaje.
     * @return El mensaje creado.
     */
    public static AiMessage user(final String content) {
        return new AiMessage(AiMessageRole.USER, content);
    }

    /**
     * Crea un mensaje de asistente.
     *
     * @param content El contenido del mensaje.
     * @return El mensaje creado.
     */
    public static AiMessage assistant(final String content) {
        return new AiMessage(AiMessageRole.ASSISTANT, content);
    }
}

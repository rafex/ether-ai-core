package dev.rafex.ether.ai.core.chat;

import java.util.Objects;

import dev.rafex.ether.ai.core.message.AiMessage;
import dev.rafex.ether.ai.core.usage.AiUsage;

/**
 * Respuesta generada por un modelo de IA.
 *
 * @param id          Identificador único de la respuesta.
 * @param model       Modelo utilizado para generar la respuesta.
 * @param message     Mensaje contenido en la respuesta.
 * @param finishReason Razón por la cual finalizó la generación.
 * @param usage       Estadísticas de uso de tokens.
 */
public record AiChatResponse(String id, String model, AiMessage message, String finishReason, AiUsage usage) {

    /**
     * Crea una nueva respuesta y normaliza los campos opcionales.
     *
     * @param id          Identificador único de la respuesta.
     * @param model       Modelo utilizado para generar la respuesta.
     * @param message     Mensaje contenido en la respuesta.
     * @param finishReason Razón por la cual finalizó la generación.
     * @param usage       Estadísticas de uso de tokens.
     */
    public AiChatResponse {
        id = id == null ? "" : id;
        model = model == null ? "" : model;
        finishReason = finishReason == null ? "" : finishReason;
        Objects.requireNonNull(message, "message");
        usage = usage == null ? AiUsage.empty() : usage;
    }

    /**
     * Devuelve el contenido de texto del mensaje.
     *
     * @return El contenido de texto.
     */
    public String text() {
        return message.content();
    }
}

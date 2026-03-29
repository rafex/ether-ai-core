package dev.rafex.ether.ai.core.chat;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import dev.rafex.ether.ai.core.message.AiMessage;

/**
 * Solicitud para generar respuestas de chat usando un modelo de IA.
 *
 * @param model            El identificador del modelo a utilizar.
 * @param messages         La lista de mensajes en la conversación.
 * @param temperature      La temperatura para controlar la aleatoriedad (0.0 - 2.0).
 * @param maxOutputTokens  El número máximo de tokens en la respuesta.
 */
public record AiChatRequest(String model, List<AiMessage> messages, Double temperature, Integer maxOutputTokens) {

    /**
     * Crea una nueva solicitud y valida los parámetros.
     *
     * @param model            El identificador del modelo a utilizar.
     * @param messages         La lista de mensajes en la conversación.
     * @param temperature      La temperatura para controlar la aleatoriedad (0.0 - 2.0).
     * @param maxOutputTokens  El número máximo de tokens en la respuesta.
     * @throws NullPointerException     si el modelo o los mensajes son nulos.
     * @throws IllegalArgumentException si el modelo está en blanco, los mensajes están vacíos,
     *                                  o los valores de temperatura/tokens están fuera de rango.
     */
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

    /**
     * Crea una solicitud con los valores por defecto para temperatura y tokens máximos.
     *
     * @param model    El identificador del modelo a utilizar.
     * @param messages Los mensajes de la conversación.
     * @return La solicitud creada.
     */
    public static AiChatRequest of(final String model, final AiMessage... messages) {
        return new AiChatRequest(model, Arrays.asList(messages), null, null);
    }
}

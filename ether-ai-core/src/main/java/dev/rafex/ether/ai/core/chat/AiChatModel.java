package dev.rafex.ether.ai.core.chat;

import java.io.IOException;

/**
 * Define el contrato para generar respuestas de chat usando modelos de IA.
 */
public interface AiChatModel {

    /**
     * Genera una respuesta de chat basada en la solicitud proporcionada.
     *
     * @param request la solicitud de chat
     * @return la respuesta generada
     * @throws IOException          si ocurre un error de entrada/salida
     * @throws InterruptedException si la operación es interrumpida
     */
    AiChatResponse generate(AiChatRequest request) throws IOException, InterruptedException;
}

package dev.rafex.ether.ai.core.error;

import java.io.IOException;

/**
 * Excepción lanzada cuando ocurre un error HTTP en una solicitud a la API de IA.
 */
public final class AiHttpException extends IOException {

    private static final long serialVersionUID = 1L;

    private final int statusCode;
    private final String responseBody;

    /**
     * Crea una nueva excepción de error HTTP.
     *
     * @param message      Mensaje descriptivo del error.
     * @param statusCode   Código de estado HTTP.
     * @param responseBody Cuerpo de la respuesta HTTP.
     */
    public AiHttpException(final String message, final int statusCode, final String responseBody) {
        super(message);
        this.statusCode = statusCode;
        this.responseBody = responseBody == null ? "" : responseBody;
    }

    /**
     * Devuelve el código de estado HTTP.
     *
     * @return El código de estado.
     */
    public int statusCode() {
        return statusCode;
    }

    /**
     * Devuelve el cuerpo de la respuesta HTTP.
     *
     * @return El cuerpo de la respuesta.
     */
    public String responseBody() {
        return responseBody;
    }
}

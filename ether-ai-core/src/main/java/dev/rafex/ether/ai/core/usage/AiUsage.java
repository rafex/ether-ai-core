package dev.rafex.ether.ai.core.usage;

/**
 * Estadísticas de uso de tokens para una respuesta de IA.
 *
 * @param inputTokens  Número de tokens en la entrada (prompt).
 * @param outputTokens Número de tokens en la salida (respuesta).
 * @param totalTokens  Total de tokens procesados.
 */
public record AiUsage(int inputTokens, int outputTokens, int totalTokens) {

    /**
     * Crea un nuevo registro de uso y valida los valores.
     *
     * @param inputTokens  Número de tokens en la entrada.
     * @param outputTokens Número de tokens en la salida.
     * @param totalTokens  Total de tokens.
     * @throws IllegalArgumentException si algún contador es negativo.
     */
    public AiUsage {
        if (inputTokens < 0 || outputTokens < 0 || totalTokens < 0) {
            throw new IllegalArgumentException("usage tokens must be non-negative");
        }
    }

    /**
     * Crea un registro de uso vacío (cero tokens).
     *
     * @return Uso vacío.
     */
    public static AiUsage empty() {
        return new AiUsage(0, 0, 0);
    }
}

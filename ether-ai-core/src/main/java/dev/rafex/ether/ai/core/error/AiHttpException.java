package dev.rafex.ether.ai.core.error;

import java.io.IOException;

public final class AiHttpException extends IOException {

    private static final long serialVersionUID = 1L;

    private final int statusCode;
    private final String responseBody;

    public AiHttpException(final String message, final int statusCode, final String responseBody) {
        super(message);
        this.statusCode = statusCode;
        this.responseBody = responseBody == null ? "" : responseBody;
    }

    public int statusCode() {
        return statusCode;
    }

    public String responseBody() {
        return responseBody;
    }
}

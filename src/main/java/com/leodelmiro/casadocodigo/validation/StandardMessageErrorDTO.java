package com.leodelmiro.casadocodigo.validation;

import java.time.Instant;

public class StandardMessageErrorDTO {
    private Instant timestamp;
    private String error;
    private String message;
    private String path;

    public StandardMessageErrorDTO(Instant timestamp, String error, String message, String path) {
        this.timestamp = timestamp;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }
}

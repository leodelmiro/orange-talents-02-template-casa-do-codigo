package com.leodelmiro.casadocodigo.validation;

public class FieldMessageDTO {

    private String field;
    private String error;

    public FieldMessageDTO(String field, String error) {
        this.field = field;
        this.error = error;
    }

    public String getField() {
        return field;
    }

    public String getError() {
        return error;
    }
}

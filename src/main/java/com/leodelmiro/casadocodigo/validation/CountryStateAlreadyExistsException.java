package com.leodelmiro.casadocodigo.validation;

public class CountryStateAlreadyExistsException extends RuntimeException {

    public CountryStateAlreadyExistsException(String msg) {
        super(msg);
    }
}

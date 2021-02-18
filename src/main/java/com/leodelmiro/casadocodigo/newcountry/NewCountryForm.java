package com.leodelmiro.casadocodigo.newcountry;

import com.leodelmiro.casadocodigo.validation.annotations.UniqueValue;

import javax.validation.constraints.NotBlank;

public class NewCountryForm {

    @NotBlank
    @UniqueValue(fieldName = "name", domainClass = Country.class)
    private String name;

    @Deprecated
    public NewCountryForm() {

    }

    public NewCountryForm(@NotBlank String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public Country toModel() {
        return new Country(this.name);
    }
}

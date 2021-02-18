package com.leodelmiro.casadocodigo.newcountry;

public class CreatedCountryResponse {

    private Long id;
    private String name;

    public CreatedCountryResponse(Country entity) {
        this.id = entity.getId();
        this.name = entity.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

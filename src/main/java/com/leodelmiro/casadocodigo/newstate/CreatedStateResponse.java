package com.leodelmiro.casadocodigo.newstate;

public class CreatedStateResponse {

    private Long id;
    private String name;
    private Long countryId;

    public CreatedStateResponse(State entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.countryId = entity.getCountry().getId();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getCountryId() {
        return countryId;
    }
}

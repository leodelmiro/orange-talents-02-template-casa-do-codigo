package com.leodelmiro.casadocodigo.newclient;

public class CreatedClientResponse {

    private Long id;
    private String email;
    private String name;
    private String surname;
    private String document;
    private String address;
    private String addressComplement;
    private String city;
    private String postalCode;
    private Long stateId;
    private Long countryId;
    private String phoneNumber;

    public CreatedClientResponse(Client entity) {
        this.id = entity.getId();
        this.email = entity.getEmail();
        this.name = entity.getName();
        this.surname = entity.getSurname();
        this.document = entity.getDocument();
        this.address = entity.getAddress();
        this.addressComplement = entity.getAddressComplement();
        this.city = entity.getCity();
        this.postalCode = entity.getPostalCode();
        if (entity.getState() != null) this.stateId = entity.getState().getId();
        this.countryId = entity.getCountry().getId();
        this.phoneNumber = entity.getPhoneNumber();
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getDocument() {
        return document;
    }

    public String getAddress() {
        return address;
    }

    public String getAddressComplement() {
        return addressComplement;
    }

    public String getCity() {
        return city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public Long getStateId() {
        return stateId;
    }

    public Long getCountryId() {
        return countryId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}

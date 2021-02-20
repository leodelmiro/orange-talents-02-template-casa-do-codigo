package com.leodelmiro.casadocodigo.newclient;

import com.leodelmiro.casadocodigo.newcountry.Country;
import com.leodelmiro.casadocodigo.newstate.State;
import com.leodelmiro.casadocodigo.validation.annotations.CEP;
import com.leodelmiro.casadocodigo.validation.annotations.CpfOrCnpj;
import com.leodelmiro.casadocodigo.validation.annotations.ExistsId;
import com.leodelmiro.casadocodigo.validation.annotations.UniqueValue;
import com.leodelmiro.casadocodigo.validation.exceptions.IllegalCountryStateException;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class NewClientForm {

    @NotBlank
    @Email
    @UniqueValue(fieldName = "email", domainClass = Client.class)
    private String email;

    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    @NotBlank
    @CpfOrCnpj
    @UniqueValue(fieldName = "document", domainClass = Client.class)
    private String document;

    @NotBlank
    private String address;

    @NotBlank
    private String addressComplement;

    @NotBlank
    private String city;

    @NotBlank
    @CEP
    private String postalCode;

    private Long stateId;

    @NotNull
    @ExistsId(fieldName = "id", domainClass = Country.class)
    private Long countryId;

    @NotBlank
    private String phoneNumber;

    @Deprecated
    public NewClientForm() {

    }

    public NewClientForm(@NotBlank @Email String email,
                         @NotBlank String name,
                         @NotBlank String surname,
                         @NotBlank String document,
                         @NotBlank String address,
                         @NotBlank String addressComplement,
                         @NotBlank String city,
                         @NotBlank @CEP String postalCode,
                         @ExistsId(fieldName = "id", domainClass = Country.class) Long stateId,
                         @NotBlank Long countryId,
                         @NotBlank String phoneNumber) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.document = document;
        this.address = address;
        this.addressComplement = addressComplement;
        this.city = city;
        this.postalCode = postalCode;
        this.stateId = stateId;
        this.countryId = countryId;
        this.phoneNumber = phoneNumber;
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

    public Client toModel(EntityManager entityManager) {
        State state = null;
        Country country = entityManager.find(Country.class, countryId);

        if (country.hasState() && stateId == null) {
            throw new IllegalCountryStateException("Existe estado nesse país.");
        }

        if (stateId != null) {
            state = entityManager.find(State.class, stateId);

            if (!state.belongsTo(countryId)) {
                throw new IllegalCountryStateException("Esse estado não pertence a esse país");
            }
        }

        return new Client(this.email, this.name, this.surname, this.document, this.address, this.addressComplement,
                this.city, this.postalCode, state, country, this.phoneNumber);
    }
}

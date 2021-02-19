package com.leodelmiro.casadocodigo.newclient;

import com.leodelmiro.casadocodigo.newcountry.Country;
import com.leodelmiro.casadocodigo.newstate.State;
import com.leodelmiro.casadocodigo.validation.annotations.CEP;
import com.leodelmiro.casadocodigo.validation.annotations.CpfOrCnpj;
import com.leodelmiro.casadocodigo.validation.annotations.ExistsId;
import com.leodelmiro.casadocodigo.validation.annotations.UniqueValue;
import org.springframework.util.Assert;

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
                         @NotBlank @CpfOrCnpj String document,
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

    public NewClientForm(@NotBlank @Email String email,
                         @NotBlank String name,
                         @NotBlank String surname,
                         @NotBlank @CpfOrCnpj String document,
                         @NotBlank String address,
                         @NotBlank String addressComplement,
                         @NotBlank String city,
                         @NotBlank @CEP String postalCode,
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
        Country country = null;

        if (stateId != null) {
            state = entityManager.find(State.class, stateId);
            Assert.state(state != null, "Você está querendo cadastrar um cliente passando um estado inválido " + stateId);
        } else {
            country = entityManager.find(Country.class, countryId);
            Assert.state(country != null, "Você está querendo cadastrar um cliente passando um país inválido " + countryId);
        }

        if (state != null) {
            return new Client(this.email, this.name, this.surname, this.document, this.address, this.addressComplement,
                    this.city, this.postalCode, state, state.getCountry(), this.phoneNumber);
        }

        return new Client(this.email, this.name, this.surname, this.document, this.address, this.addressComplement,
                this.city, this.postalCode, country, this.phoneNumber);
    }

}

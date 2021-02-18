package com.leodelmiro.casadocodigo.newclient;

import com.leodelmiro.casadocodigo.newcountry.Country;
import com.leodelmiro.casadocodigo.newstate.State;
import com.leodelmiro.casadocodigo.validation.annotations.CEP;
import com.leodelmiro.casadocodigo.validation.annotations.CpfOrCnpj;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Email
    @Column(unique = true)
    private String email;

    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    @NotBlank
    @CpfOrCnpj
    @Column(unique = true)
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

    @ManyToOne
    @JoinColumn(name = "state_id")
    private State state;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @NotBlank
    private String phoneNumber;

    @Deprecated
    public Client(){

    }

    public Client(@NotBlank @Email String email,
                  @NotBlank String name,
                  @NotBlank String surname,
                  @NotBlank @CpfOrCnpj String document,
                  @NotBlank String address,
                  @NotBlank String addressComplement,
                  @NotBlank String city,
                  @NotBlank @CEP String postalCode,
                  State state,
                  @NotNull Country country,
                  @NotBlank String phoneNumber) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.document = document;
        this.address = address;
        this.addressComplement = addressComplement;
        this.city = city;
        this.postalCode = postalCode;
        this.state = state;
        this.country = country;
        this.phoneNumber = phoneNumber;
    }

    public Client(@NotBlank @Email String email,
                  @NotBlank String name,
                  @NotBlank String surname,
                  @NotBlank @CpfOrCnpj String document,
                  @NotBlank String address,
                  @NotBlank String addressComplement,
                  @NotBlank String city,
                  @NotBlank @CEP String postalCode,
                  @NotNull Country country,
                  @NotBlank String phoneNumber) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.document = document;
        this.address = address;
        this.addressComplement = addressComplement;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
        this.phoneNumber = phoneNumber;
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

    public State getState() {
        return state;
    }

    public Country getCountry() {
        return country;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}

package com.leodelmiro.casadocodigo.newstate;

import com.leodelmiro.casadocodigo.newcountry.Country;
import org.springframework.util.Assert;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_states", uniqueConstraints = {@UniqueConstraint(columnNames = {"country_id", "name"})})
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @Deprecated
    public State(){

    }

    public State(@NotBlank String name, @NotNull Country country) {
        Assert.hasLength(name, "Nome é obrigatório!");
        Assert.notNull(country, "País é obrigatório!");

        this.name = name;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Country getCountry() {
        return country;
    }

    public boolean belongsTo(Long countryId) {
        return country.getId().equals(countryId);
    }
}

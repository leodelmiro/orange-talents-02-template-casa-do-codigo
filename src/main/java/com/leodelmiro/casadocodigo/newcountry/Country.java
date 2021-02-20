package com.leodelmiro.casadocodigo.newcountry;

import com.leodelmiro.casadocodigo.newstate.State;
import org.springframework.util.Assert;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "tb_countries")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "country", fetch = FetchType.EAGER)
    private List<State> states;

    @Deprecated
    public Country() {

    }

    public Country(@NotBlank String name) {
        Assert.hasLength(name, "Nome é obrigatório!");

        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean hasState() {
        return !states.isEmpty();
    }
}

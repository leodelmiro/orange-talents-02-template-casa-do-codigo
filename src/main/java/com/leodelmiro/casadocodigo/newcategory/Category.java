package com.leodelmiro.casadocodigo.newcategory;

import org.springframework.util.Assert;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "tb_categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true)
    private String name;

    @Deprecated
    public Category() {

    }

    public Category(@NotBlank String name) {
        Assert.hasLength(name, "O nome é obrigatório!");

        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

package com.leodelmiro.casadocodigo.newauthor;

import java.time.Instant;

public class AuthorDTO {

    private Long id;

    private String name;

    private String email;

    private String description;

    private Instant createdAt;

    public AuthorDTO(Author entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.email = entity.getEmail();
        this.description = entity.getDescription();
        this.createdAt = entity.getCreatedAt();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDescription() {
        return description;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

}

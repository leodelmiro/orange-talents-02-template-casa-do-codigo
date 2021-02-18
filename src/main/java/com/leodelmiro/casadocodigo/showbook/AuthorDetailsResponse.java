package com.leodelmiro.casadocodigo.showbook;

import com.leodelmiro.casadocodigo.newauthor.Author;

public class AuthorDetailsResponse {

    private String name;
    private String description;

    public AuthorDetailsResponse(Author entity){
        this.name = entity.getName();
        this.description = entity.getDescription();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}

package com.leodelmiro.casadocodigo.newauthor;

import com.leodelmiro.casadocodigo.newcategory.Category;
import com.leodelmiro.casadocodigo.validation.UniqueValue;
import org.springframework.beans.factory.annotation.Value;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class NewAuthorForm {

    @NotBlank
    private String name;

    @NotBlank
    @Email
    @UniqueValue(fieldName = "email", domainClass = Author.class)
    private String email;

    @NotBlank
    @Size(max = 400)
    private String description;

    public NewAuthorForm(@NotBlank String name, @NotBlank @Email String email, @NotBlank @Size(max = 400) String description) {
        this.name = name;
        this.email = email;
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public Author toModel() {
        return new Author(this.name, this.email, this.description);
    }

}

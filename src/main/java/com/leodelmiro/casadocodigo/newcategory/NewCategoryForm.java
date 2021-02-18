package com.leodelmiro.casadocodigo.newcategory;

import com.leodelmiro.casadocodigo.validation.annotations.UniqueValue;

import javax.validation.constraints.NotBlank;

public class NewCategoryForm {

    @NotBlank
    @UniqueValue(fieldName = "name", domainClass = Category.class)
    private String name;

    @Deprecated
    public NewCategoryForm() {
    }

    public NewCategoryForm(@NotBlank String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Category toModel(){
        return new Category(this.name);
    }
}

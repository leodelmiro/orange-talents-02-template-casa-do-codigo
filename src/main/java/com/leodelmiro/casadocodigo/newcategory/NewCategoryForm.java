package com.leodelmiro.casadocodigo.newcategory;

import javax.validation.constraints.NotBlank;

public class NewCategoryForm {

    @NotBlank
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

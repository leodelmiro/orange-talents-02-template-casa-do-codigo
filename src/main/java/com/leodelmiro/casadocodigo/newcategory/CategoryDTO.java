package com.leodelmiro.casadocodigo.newcategory;

public class CategoryDTO {

    private Long id;
    private String name;

    public CategoryDTO(Category entity) {
        this.id = entity.getId();
        this.name = entity.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}

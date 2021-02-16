package com.leodelmiro.casadocodigo.newcategory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public CategoryDTO insert(@Valid @RequestBody NewCategoryForm newCategoryForm) {
        Category newCategory = newCategoryForm.toModel();

        entityManager.persist(newCategory);

        return new CategoryDTO(newCategory);
    }
}

package com.leodelmiro.casadocodigo.newcategory;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public CreatedCategoryResponse insert(@Valid @RequestBody NewCategoryForm newCategoryForm) {
        Category newCategory = newCategoryForm.toModel();

        entityManager.persist(newCategory);

        return new CreatedCategoryResponse(newCategory);
    }
}

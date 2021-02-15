package com.leodelmiro.casadocodigo.newAuthor;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/authors")
public class AuthorController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public Author insert(@Valid @RequestBody NewAuthorForm newAuthorForm) {
        Author newAuthor = newAuthorForm.toModel();
        entityManager.persist(newAuthor);
        return newAuthor;
    }
}

package com.leodelmiro.casadocodigo.newauthor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private DuplicatedEmailValidator duplicatedEmailValidator;

    @InitBinder
    void initDuplicatedEmailValidator(WebDataBinder binder){
        binder.addValidators(duplicatedEmailValidator);
    }

    @PostMapping
    @Transactional
    public AuthorDTO insert(@Valid @RequestBody NewAuthorForm newAuthorForm) {
        Author newAuthor = newAuthorForm.toModel();

        entityManager.persist(newAuthor);

        return new AuthorDTO(newAuthor);
    }
}

package com.leodelmiro.casadocodigo.newbook;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("/books")
public class BookController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public BookDTO insert(@Valid @RequestBody NewBookForm newBookForm) {
        Book newBook = newBookForm.toModel(entityManager);

        entityManager.persist(newBook);

        return new BookDTO(newBook);
    }
}

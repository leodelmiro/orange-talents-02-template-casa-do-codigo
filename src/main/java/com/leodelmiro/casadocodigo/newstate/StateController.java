package com.leodelmiro.casadocodigo.newstate;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("/states")
public class StateController {


    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public CreatedStateResponse insert(@Valid @RequestBody NewStateForm newStateForm) {
        State newState = newStateForm.toModel(entityManager);

        entityManager.persist(newState);

        return new CreatedStateResponse(newState);
    }
}

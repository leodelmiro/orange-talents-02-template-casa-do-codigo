package com.leodelmiro.casadocodigo.newclient;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public CreatedClientResponse insert(@Valid @RequestBody NewClientForm newClientForm) {
        Client newClient = newClientForm.toModel(entityManager);

        entityManager.persist(newClient);

        return new CreatedClientResponse(newClient);
    }
}

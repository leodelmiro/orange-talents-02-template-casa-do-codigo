package com.leodelmiro.casadocodigo.newcountry;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("/countries")
public class CountryController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public CreatedCountryResponse insert(@Valid @RequestBody NewCountryForm newCountryForm) {
        Country newCountry = newCountryForm.toModel();

        entityManager.persist(newCountry);

        return new CreatedCountryResponse(newCountry);
    }
}

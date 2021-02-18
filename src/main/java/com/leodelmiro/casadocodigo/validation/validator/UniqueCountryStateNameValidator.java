package com.leodelmiro.casadocodigo.validation.validator;

import com.leodelmiro.casadocodigo.validation.annotations.UniqueCountryStateName;
import com.leodelmiro.casadocodigo.validation.exceptions.CountryStateAlreadyExistsException;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class UniqueCountryStateNameValidator implements ConstraintValidator<UniqueCountryStateName, Object> {

    private String attributeField;
    private Class<?> klass;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void initialize(UniqueCountryStateName params) {
        attributeField = params.attributeField();
        klass = params.domainClass();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        String stateName = value.toString().split("'")[1];
        Long countryId = Long.parseLong(value.toString().split("=")[2]);

        Query query = entityManager.createQuery("SELECT c FROM " + klass.getName() + " c WHERE " + attributeField + "=:stateName AND c.country.id =:countryId");
        query.setParameter("stateName", stateName);
        query.setParameter("countryId", countryId);

        List<?> list = query.getResultList();
        Assert.isTrue(list.size() <= 1, "Foi encontrado mais de um " + klass + "com o atributo " + attributeField + " informado!");

        if (!list.isEmpty()) {
            throw new CountryStateAlreadyExistsException("Nome de estado já existente nesse país");
        }

        return true;
    }

}

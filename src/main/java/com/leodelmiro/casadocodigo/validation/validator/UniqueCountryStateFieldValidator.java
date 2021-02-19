package com.leodelmiro.casadocodigo.validation.validator;

import com.leodelmiro.casadocodigo.validation.annotations.UniqueCountryStateField;
import com.leodelmiro.casadocodigo.validation.exceptions.CountryStateAlreadyExistsException;
import org.springframework.beans.BeanWrapperImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class UniqueCountryStateFieldValidator implements ConstraintValidator<UniqueCountryStateField, Object> {

    private String stateAttribute;
    private String countryField;
    private Class<?> klass;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void initialize(UniqueCountryStateField params) {
        stateAttribute = params.stateAttribute();
        countryField = params.countryField();
        klass = params.domainClass();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        Query query = entityManager.createQuery(
                "SELECT c FROM " + klass.getName() + " c WHERE " + stateAttribute + "=:stateAttributeValue AND c.country.id =:countryId");

        String name = (String) new BeanWrapperImpl(value).getPropertyValue(stateAttribute);
        query.setParameter("stateAttributeValue", name);

        Long countryId = (Long) new BeanWrapperImpl(value).getPropertyValue(countryField);
        query.setParameter("countryId", countryId);

        List<?> list = query.getResultList();

        if (!list.isEmpty()) {
            throw new CountryStateAlreadyExistsException("Nome de estado já existente nesse país");
        }

        return true;
    }

}

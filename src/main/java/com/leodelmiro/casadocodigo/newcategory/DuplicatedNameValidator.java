package com.leodelmiro.casadocodigo.newcategory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class DuplicatedNameValidator implements Validator {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return NewCategoryForm.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }

        NewCategoryForm categoryForm = (NewCategoryForm) target;
        Optional<Category> possibleCategory = categoryRepository.findByName(categoryForm.getName());

        if (possibleCategory.isPresent()) {
            errors.rejectValue("name", "DuplicatedName.newCategoryForm.name");
        }
    }
}

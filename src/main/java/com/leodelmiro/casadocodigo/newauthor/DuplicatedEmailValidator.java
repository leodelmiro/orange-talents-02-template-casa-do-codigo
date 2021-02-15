package com.leodelmiro.casadocodigo.newauthor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class DuplicatedEmailValidator implements Validator {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return NewAuthorForm.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()){
            return;
        }

        NewAuthorForm authorForm = (NewAuthorForm) target;
        Optional<Author> possibleAuthor = authorRepository.findByEmail(authorForm.getEmail());

        if (possibleAuthor.isPresent()){
            errors.rejectValue("email", "DuplicatedEmail.newAuthorForm.email");
        }
    }
}

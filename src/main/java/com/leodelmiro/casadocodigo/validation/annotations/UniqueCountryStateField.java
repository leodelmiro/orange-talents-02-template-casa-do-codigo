package com.leodelmiro.casadocodigo.validation.annotations;

import com.leodelmiro.casadocodigo.validation.validator.UniqueCountryStateFieldValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = UniqueCountryStateFieldValidator.class)
@Target({TYPE})
@Retention(RUNTIME)
@Documented
public @interface UniqueCountryStateField {
    String message() default "Duplicated Country State name";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String stateAttribute();

    String countryField();

    Class<?> domainClass();
}

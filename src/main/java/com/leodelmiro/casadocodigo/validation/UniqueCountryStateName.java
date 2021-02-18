package com.leodelmiro.casadocodigo.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.CLASS;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = UniqueCountryStateNameValidator.class)
@Target({TYPE, FIELD})
@Retention(RUNTIME)
@Documented
public @interface UniqueCountryStateName {
    String message() default "Duplicated Country State name";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String attributeField();

    Class<?> domainClass();
}

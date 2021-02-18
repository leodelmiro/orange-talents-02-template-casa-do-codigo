package com.leodelmiro.casadocodigo.validation.annotations;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Pattern;
import java.lang.annotation.*;

@Pattern(regexp = "[0-9]{5}-[0-9]{3}")
@Documented
@Constraint(
        validatedBy = {}
)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
public @interface CEP {
    String message() default "Must be valid CEP format";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

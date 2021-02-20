package com.leodelmiro.casadocodigo.validation.annotations;

import org.hibernate.validator.constraints.CompositionType;
import org.hibernate.validator.constraints.ConstraintComposition;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@CPF
@CNPJ
@ConstraintComposition(CompositionType.OR)
public @interface CpfOrCnpj {

    String message() default "Invalid CPF/CNPJ format";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

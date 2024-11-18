package com.devsuperior.dslist.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = DifferentIndexesValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface DifferentIndexes {
    String message() default "sourceIndex e targetIndex não podem ser iguais";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

package ru.kyper.TestSwagger.entity;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = BackofficeObjectValidatorV2.class)
public @interface ValidatedBackofficeObjectV2 {

	String message() default "sdfdsf";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}

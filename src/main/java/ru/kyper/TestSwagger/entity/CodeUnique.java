package ru.kyper.TestSwagger.entity;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({METHOD, FIELD, ANNOTATION_TYPE, PARAMETER})
@Retention(RUNTIME)
@Constraint(validatedBy = {CodeUniqueValidator.class})
@Documented
public @interface CodeUnique {
	String message() default "Компания с таким ИНН уже существует";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
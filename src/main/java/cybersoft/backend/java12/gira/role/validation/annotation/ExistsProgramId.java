package cybersoft.backend.java12.gira.role.validation.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import cybersoft.backend.java12.gira.role.validation.validator.ExistsProgramValidator;

@Constraint(validatedBy = ExistsProgramValidator.class)
@Retention(RUNTIME)
@Target(FIELD)
public @interface ExistsProgramId {
	public String message() default "This program does not exist";
	
	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
}

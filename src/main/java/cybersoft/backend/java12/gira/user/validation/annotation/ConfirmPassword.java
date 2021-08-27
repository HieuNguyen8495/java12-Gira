package cybersoft.backend.java12.gira.user.validation.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import cybersoft.backend.java12.gira.user.validation.validator.ConfirmPasswordValidator;

@Constraint(validatedBy = ConfirmPasswordValidator.class)
@Retention(RUNTIME)
@Target(ElementType.TYPE)
public @interface ConfirmPassword {
	public String message() default "This password is wrong";
	
	Class<?>[] groups() default { };
	Class<? extends Payload>[] payload() default { };
}

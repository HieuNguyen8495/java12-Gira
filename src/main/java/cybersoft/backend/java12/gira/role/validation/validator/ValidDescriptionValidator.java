package cybersoft.backend.java12.gira.role.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import cybersoft.backend.java12.gira.common.util.ValidatorUtils;
import cybersoft.backend.java12.gira.role.validation.annotation.ValidDescription;

public class ValidDescriptionValidator implements ConstraintValidator<ValidDescription, String> {
	
	public String message;
	
	@Override
	public void initialize(ValidDescription constraintAnnotation) {
		this.message = constraintAnnotation.message();
	}
	

	@Override
	public boolean isValid(String description, ConstraintValidatorContext context) {
		//check null
		if(description == null) {
			ValidatorUtils.addError(context, message);
		return false;
		}
		//immuable - check khoảng cách
		description = description.trim();
	
		//check length
		if(description.length() < 10) {
			ValidatorUtils.addError(context, message);
		return false;
		}
		return true;
	}

}

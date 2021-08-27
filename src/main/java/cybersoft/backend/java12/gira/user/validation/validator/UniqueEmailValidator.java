package cybersoft.backend.java12.gira.user.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import cybersoft.backend.java12.gira.common.util.ValidatorUtils;
import cybersoft.backend.java12.gira.user.service.UserService;
import cybersoft.backend.java12.gira.user.validation.annotation.UniqueEmail;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {
	public String message;
	public UserService service;
	
	public UniqueEmailValidator(UserService userService) {
		service = userService;
	}
	
	@Override
	public void initialize(UniqueEmail constraintAnnotation) {
		this.message = constraintAnnotation.message();
	}


	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		if(email == null)
			return false;
		
		boolean isTaken = service.isTakenEmail(email);
		
		if(!isTaken)
		    return true;
		
		ValidatorUtils.addError(context, message);
		return false;
	}

}

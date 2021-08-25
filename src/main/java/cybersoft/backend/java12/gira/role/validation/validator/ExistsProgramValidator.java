package cybersoft.backend.java12.gira.role.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import cybersoft.backend.java12.gira.common.util.ValidatorUtils;
import cybersoft.backend.java12.gira.role.service.itf.ProgramService;
import cybersoft.backend.java12.gira.role.validation.annotation.ExistsProgramId;

public class ExistsProgramValidator implements ConstraintValidator<ExistsProgramId, Long> {
	public String message;
	public ProgramService service;
	
	@Override
	public void initialize(ExistsProgramId constraintAnnotation) {
		this.message = constraintAnnotation.message();
	}
	
	public ExistsProgramValidator(ProgramService programService) {
		service = programService; 
	}
	
	@Override
	public boolean isValid(Long programId, ConstraintValidatorContext context) {
		boolean isExisted = service.isExistedProgramId(programId);
		
		if(isExisted)
			return true;
		
		ValidatorUtils.addError(context, message);
		return false;
	}

}

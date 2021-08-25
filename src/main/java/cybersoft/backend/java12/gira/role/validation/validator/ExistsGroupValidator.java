package cybersoft.backend.java12.gira.role.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import cybersoft.backend.java12.gira.common.util.ValidatorUtils;
import cybersoft.backend.java12.gira.role.service.itf.GroupService;
import cybersoft.backend.java12.gira.role.service.itf.ProgramService;
import cybersoft.backend.java12.gira.role.validation.annotation.ExistsGroupId;
import cybersoft.backend.java12.gira.role.validation.annotation.ExistsProgramId;

public class ExistsGroupValidator implements ConstraintValidator<ExistsGroupId, Long> {
	public String message;
	public GroupService service;
	
	@Override
	public void initialize(ExistsGroupId constraintAnnotation) {
		this.message = constraintAnnotation.message();
		
	}

	public ExistsGroupValidator(GroupService groupService) {
		service = groupService; 
	}
	
	@Override
	public boolean isValid(Long groupId, ConstraintValidatorContext context) {
		boolean isExisted = service.isExistedGroupId(groupId);
		
		if(isExisted)
			return true;
		
		ValidatorUtils.addError(context, message);
		return false;
	}

}

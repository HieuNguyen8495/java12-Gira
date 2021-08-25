package cybersoft.backend.java12.gira.role.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import cybersoft.backend.java12.gira.common.util.ValidatorUtils;
import cybersoft.backend.java12.gira.role.service.itf.RoleService;
import cybersoft.backend.java12.gira.role.validation.annotation.ExistsRoleId;

public class ExistsRoleIValidator implements ConstraintValidator<ExistsRoleId, Long>{
	public String message;
	public RoleService service;
	
	
	@Override
	public void initialize(ExistsRoleId constraintAnnotation) {
		this.message = constraintAnnotation.message();
	}
	
	public ExistsRoleIValidator(RoleService roleService) {
		service = roleService;
	}
	
	@Override
	public boolean isValid(Long roleId, ConstraintValidatorContext context) {
		boolean isExisted = service.isExistedId(roleId);
				
		if(isExisted)
			return true;
		
		ValidatorUtils.addError(context, message);
		return false;
	}

}

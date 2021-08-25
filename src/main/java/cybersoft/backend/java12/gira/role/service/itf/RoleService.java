package cybersoft.backend.java12.gira.role.service.itf;

import java.util.List;

import javax.validation.Valid;

import cybersoft.backend.java12.gira.dto.AddProgramDto;
import cybersoft.backend.java12.gira.dto.CreateRoleDto;
import cybersoft.backend.java12.gira.dto.RoleDto;
import cybersoft.backend.java12.gira.role.entity.Role;

public interface RoleService {
	List<RoleDto> findAll();

	Role addNewRole(CreateRoleDto dto);

	Role addProgram(AddProgramDto dto);

	boolean isTakenName(String roleName);

	boolean isExistedId(Long roleId);

	Role removeProgram(AddProgramDto dto);

	
}

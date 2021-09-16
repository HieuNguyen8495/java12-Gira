package cybersoft.backend.java12.gira.role.service.itf;

import java.util.List;

import javax.validation.Valid;

import cybersoft.backend.java12.gira.dto.AddUserDto;
import cybersoft.backend.java12.gira.dto.CreateGroupDto;
import cybersoft.backend.java12.gira.dto.GroupDto;
import cybersoft.backend.java12.gira.role.entity.Group;

public interface GroupService {
	List<GroupDto> findAll();
	
	Group addNewGroup(CreateGroupDto groupDto);

	boolean isExistedGroupId(Long groupId);

	Group addNewUserToGroup(AddUserDto dto);
}

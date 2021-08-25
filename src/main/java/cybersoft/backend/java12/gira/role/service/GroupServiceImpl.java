package cybersoft.backend.java12.gira.role.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cybersoft.backend.java12.gira.dto.CreateGroupDto;
import cybersoft.backend.java12.gira.dto.GroupDto;
import cybersoft.backend.java12.gira.role.entity.Group;
import cybersoft.backend.java12.gira.role.repository.GroupRepository;
import cybersoft.backend.java12.gira.role.service.itf.GroupService;


@Service
public class GroupServiceImpl implements GroupService {
	private GroupRepository repository;

	public GroupServiceImpl(GroupRepository groupRepository) {
		repository = groupRepository;
	}

	@Override
	public List<GroupDto> findAll() {
		return repository.findAllGroup();
	}

	@Override
	public Group addNewGroup(CreateGroupDto groupDto) {
		Group newGroup = new Group();
		
		newGroup.setName(groupDto.getName());
		newGroup.setDescription(groupDto.getDescription());
		
		return repository.save(newGroup);
	}

	
	@Override
	public boolean isExistedGroupId(Long groupId) {
		return repository.existsById(groupId);
	}



	
	
}
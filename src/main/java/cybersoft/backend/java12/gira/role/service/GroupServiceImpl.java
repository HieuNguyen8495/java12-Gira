package cybersoft.backend.java12.gira.role.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cybersoft.backend.java12.gira.dto.AddUserDto;
import cybersoft.backend.java12.gira.dto.CreateGroupDto;
import cybersoft.backend.java12.gira.dto.GroupDto;
import cybersoft.backend.java12.gira.role.entity.Group;
import cybersoft.backend.java12.gira.role.repository.GroupRepository;
import cybersoft.backend.java12.gira.role.service.itf.GroupService;
import cybersoft.backend.java12.gira.user.entity.User;
import cybersoft.backend.java12.gira.user.repository.UserRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
@Transactional(readOnly = true) //
public class GroupServiceImpl implements GroupService {
	private GroupRepository repository;
	private UserRepository userRepository;

	//Bỏ cái constructor này đi vì đã có @AllArgsConstructor của Lambok
//	public GroupServiceImpl(GroupRepository groupRepository, UserRepository userRepository) {
//		repository = groupRepository;
//		this.userRepository = userRepository;
//	}

	@Override
	public List<GroupDto> findAll() {
		return repository.findAllGroup();
	}

	@Override
	public Group addNewGroup(CreateGroupDto groupDto) {
//		Group newGroup = new Group();
//		newGroup.setName(groupDto.getName());
//		newGroup.setDescription(groupDto.getDescription());
		
		Group newGroup = Group.builder()
						.name(groupDto.getName())
						.description(groupDto.getDescription())
						.build();
		return repository.save(newGroup);
	}

	@Override
	public boolean isExistedGroupId(Long groupId) {
		return repository.existsById(groupId);
	}

	@Override
	public Group addNewUserToGroup(AddUserDto dto) {
		Group group = repository.getById(dto.getGroupId());
		User user = userRepository.getById(dto.getUserId());
		group.addUser(user);
		
		return repository.save(group);
	}

}
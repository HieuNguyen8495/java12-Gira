package cybersoft.backend.java12.gira.role.service;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import cybersoft.backend.java12.gira.dto.AddProgramDto;
import cybersoft.backend.java12.gira.dto.CreateRoleDto;
import cybersoft.backend.java12.gira.dto.RoleDto;
import cybersoft.backend.java12.gira.role.entity.Program;
import cybersoft.backend.java12.gira.role.entity.Role;
import cybersoft.backend.java12.gira.role.repository.ProgramRepository;
import cybersoft.backend.java12.gira.role.repository.RoleRepository;
import cybersoft.backend.java12.gira.role.service.itf.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	private RoleRepository repository;
	private ProgramRepository programRepository;
	
	public RoleServiceImpl(RoleRepository roleRepository, ProgramRepository programRepository) {
		repository = roleRepository;
		this.programRepository = programRepository;
	}
	
	@Override
	public List<RoleDto> findAll() {
		return repository.findAllDto();
	
	}
	
	@Override
	public Role addNewRole(CreateRoleDto dto) {
		Role newRole = new Role();
		
		newRole.setName(dto.getName().toUpperCase());
		newRole.setDescription(dto.getDescription());
		
		return repository.save(newRole);
	}

	@Override
	public Role addProgram(AddProgramDto dto) {
		Role role = repository.getById(dto.getRoleId());
		Program program = programRepository.getById(dto.getProgramId());
		
		role.addProgram(program);
		return repository.save(role);
	}

	@Override
	public boolean isTakenName(String roleName) {
		return repository.countByName(roleName.toUpperCase()) >= 1;
	}

	@Override
	public boolean isExistedId(Long roleId) {
		return repository.existsById(roleId);
	}

	@Override
	public Role removeProgram(AddProgramDto dto) {
		Role role = repository.getById(dto.getRoleId());
		Program program = programRepository.getById(dto.getProgramId());
		
		role.removeProgram(program);
		
		return repository.save(role);
	}
	

}

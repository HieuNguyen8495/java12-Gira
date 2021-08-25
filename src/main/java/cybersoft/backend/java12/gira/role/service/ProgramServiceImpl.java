package cybersoft.backend.java12.gira.role.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cybersoft.backend.java12.gira.dto.CreateProgramDto;
import cybersoft.backend.java12.gira.dto.ProgramDto;
import cybersoft.backend.java12.gira.role.entity.Program;
import cybersoft.backend.java12.gira.role.repository.ProgramRepository;
import cybersoft.backend.java12.gira.role.service.itf.ProgramService;

@Service
public class ProgramServiceImpl implements ProgramService {
	public ProgramRepository repository;
	
	public ProgramServiceImpl(ProgramRepository programRepository) {
		repository = programRepository;
	}
	
	@Override
	public List<ProgramDto> findAll() {
		return repository.findAllDto();
	}

	@Override
	public Program saveProgram(CreateProgramDto dto) {
		Program newProgram = new Program();
		
		newProgram.setName(dto.getName());
		newProgram.setMethod(dto.getMethod());;
		newProgram.setPath(dto.getPath());
		
		return repository.save(newProgram);
	}

	@Override
	public boolean isExistedProgramId(Long programId) {
		return repository.existsById(programId);
	}

}

package cybersoft.backend.java12.gira.role.service.itf;

import java.util.List;

import javax.validation.Valid;

import cybersoft.backend.java12.gira.dto.CreateProgramDto;
import cybersoft.backend.java12.gira.dto.ProgramDto;
import cybersoft.backend.java12.gira.role.entity.Program;

public interface ProgramService {
	
	public List<ProgramDto> findAll();
	
	Program saveProgram(CreateProgramDto dto);

	public boolean isExistedProgramId(Long programId);
}

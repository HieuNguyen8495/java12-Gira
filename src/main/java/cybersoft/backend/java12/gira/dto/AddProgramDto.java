package cybersoft.backend.java12.gira.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import cybersoft.backend.java12.gira.role.validation.annotation.ExistsProgramId;
import cybersoft.backend.java12.gira.role.validation.annotation.ExistsRoleId;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddProgramDto {
	@NotNull
	@Min(value = 1)
	@ExistsRoleId
	private Long roleId;
	
	@NotNull
	@Min(value = 1)
	@ExistsProgramId
	private Long programId;
}

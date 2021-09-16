package cybersoft.backend.java12.gira.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import cybersoft.backend.java12.gira.role.util.HttpMethods;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class UpdateRoleDto {
	@NotNull
	private Long id;
	
	@NotBlank
	private String name;
	
	private String description;
}

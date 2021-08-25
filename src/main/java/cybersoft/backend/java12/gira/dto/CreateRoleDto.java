package cybersoft.backend.java12.gira.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import cybersoft.backend.java12.gira.role.validation.annotation.UniqueRoleName;
import cybersoft.backend.java12.gira.role.validation.annotation.ValidDescription;

public class CreateRoleDto {

	@NotBlank(message = "{role.name.not-blank}")
	@Size(min = 3, max = 50, message = "{role.name.size}")
	@UniqueRoleName
	private String name;
	
	@ValidDescription
	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}

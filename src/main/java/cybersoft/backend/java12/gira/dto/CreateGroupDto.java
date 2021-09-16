package cybersoft.backend.java12.gira.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import cybersoft.backend.java12.gira.role.validation.annotation.ValidDescription;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateGroupDto {
	@NotBlank(message ="{group.name.not-blank}")
	@Size(min = 3, max = 50, message ="{group.name.size}")
	private String name;
	
	@ValidDescription
	private String description;
}

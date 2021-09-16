package cybersoft.backend.java12.gira.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddUserDto {
	@NotNull
	@Min(value = 1)
	private Long userId;
	
	@NotNull
	@Min(value = 1)
	private Long groupId;
}

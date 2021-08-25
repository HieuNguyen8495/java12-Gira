package cybersoft.backend.java12.gira.dto;

import java.util.Set;

import cybersoft.backend.java12.gira.role.entity.Role;
import cybersoft.backend.java12.gira.role.util.HttpMethods;

public interface ProgramDto {
	// projection
	public Long getId();
	public String getName();
	public HttpMethods getMethod();
	public String getPath();
	public Set<Role> getRoles();
}

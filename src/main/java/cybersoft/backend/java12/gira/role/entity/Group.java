package cybersoft.backend.java12.gira.role.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import cybersoft.backend.java12.gira.common.entity.BaseEntity;

@Entity(name="gira_group")
public class Group extends BaseEntity {
	
	private String name;
	private String decription;
	
	@OneToMany(mappedBy = "group")
	private List<Role> roles = new ArrayList<>();
}

package cybersoft.backend.java12.gira.role.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cybersoft.backend.java12.gira.common.entity.BaseEntity;


@Entity
@Table(name="gira_role")
public class Role extends BaseEntity {
	
	private String name;
	private String description;
	
//	@ManyToOne
//	private Group group;
	
	@ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinTable(name = "gira_role_grogram" , joinColumns = @JoinColumn(name ="role_id"),
							inverseJoinColumns = @JoinColumn(name ="program_id"))
	private Set<Program> programs = new HashSet<>();
	
	@ManyToMany(mappedBy = "roles")
	private Set<Group> groups = new HashSet<>();
}

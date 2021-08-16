package cybersoft.backend.java12.gira.role.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import cybersoft.backend.java12.gira.common.entity.BaseEntity;

@Entity(name="gira_group")
public class Group extends BaseEntity {
	
	private String name;
	private String decription;
	
//	@OneToMany(mappedBy = "group")
//	private List<Role> roles = new ArrayList<>();
	
	@ManyToMany(cascade = {CascadeType.MERGE , CascadeType.PERSIST})
	@JoinTable(name = "gira_group_role",
				joinColumns = @JoinColumn(name = "group_id"),
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();
}

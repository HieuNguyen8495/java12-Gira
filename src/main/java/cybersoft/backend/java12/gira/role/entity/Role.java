package cybersoft.backend.java12.gira.role.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import cybersoft.backend.java12.gira.common.entity.BaseEntity;
import cybersoft.backend.java12.gira.role.util.HttpMethods;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"groups","programs"})
@EqualsAndHashCode(exclude = {"groups","programs"}, callSuper = false)
@Entity
@Table(name="gira_role")
public class Role extends BaseEntity {
	
	@NotNull
	@Size(min = 3, max = 50)
	@Column(unique= true)
	private String name;
	
	private String description;
	
//	@ManyToOne
//	private Group group;
	
	@ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinTable(name = "gira_role_grogram" , joinColumns = @JoinColumn(name ="role_id"),
							inverseJoinColumns = @JoinColumn(name ="program_id"))
	@JsonIgnore
	@Builder.Default
	private Set<Program> programs = new HashSet<>();
	
	@ManyToMany(mappedBy = "roles")
	@JsonIgnore
	@Builder.Default
	private Set<Group> groups = new HashSet<>();
	
	
	//Helper method
	public void addProgram(Program program) {
		this.programs.add(program);
		program.getRoles().add(this);
	}
	
	public void removeProgram(Program program) {
		this.programs.remove(program);
		program.getRoles().add(this);
	}
}

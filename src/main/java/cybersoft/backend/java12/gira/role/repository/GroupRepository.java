package cybersoft.backend.java12.gira.role.repository;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cybersoft.backend.java12.gira.dto.GroupDto;
import cybersoft.backend.java12.gira.role.entity.Group;


@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
	
	

	@Transactional(readOnly = true)
	@Query("SELECT g FROM Group g")
	List<GroupDto> findAllGroup();

}

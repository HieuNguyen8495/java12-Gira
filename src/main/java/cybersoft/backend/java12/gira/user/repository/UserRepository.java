package cybersoft.backend.java12.gira.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cybersoft.backend.java12.gira.user.dto.UserDto;
import cybersoft.backend.java12.gira.user.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User , Long>{
	
	@Query("SELECT u FROM User u") // JPQL
	List<UserDto> findAllUserDto();

	boolean existsByEmail(String email);

	int countByUsername(String username);

	int countByEmail(String email);

	

}

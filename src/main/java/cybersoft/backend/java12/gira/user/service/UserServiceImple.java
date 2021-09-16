package cybersoft.backend.java12.gira.user.service;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import cybersoft.backend.java12.gira.user.dto.CreateUserDto;
import cybersoft.backend.java12.gira.user.dto.UserDto;
import cybersoft.backend.java12.gira.user.entity.User;
import cybersoft.backend.java12.gira.user.repository.UserRepository;
import cybersoft.backend.java12.gira.user.util.UserStatus;

@Service
public class UserServiceImple implements UserService{
	private UserRepository repository;
	private PasswordEncoder encoder;
	
	public UserServiceImple(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		repository = userRepository;
		encoder = passwordEncoder;
	}

	@Override
	public List<UserDto> findAllDto() {
		return repository.findAllUserDto();
	}

	@Override
	public boolean isTakenUsername(String username) {
		return repository.countByUsername(username) >= 1;
	}

	@Override
	public boolean isTakenEmail(String email) {
		return repository.countByEmail(email) >= 1;
	}

	
	@Override
	public User createUser(CreateUserDto dto) {
		User newUser = new User();
		
		newUser.setUsername(dto.getUsername());
		newUser.setPassword(encoder.encode(dto.getPassword()));
		newUser.setEmail(dto.getEmail());
		newUser.setStatus(UserStatus.ACTIVE);
		
		return repository.save(newUser);
	}

	
	
}

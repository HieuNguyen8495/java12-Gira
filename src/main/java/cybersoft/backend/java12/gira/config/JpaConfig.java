package cybersoft.backend.java12.gira.config;

import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.context.SecurityContextHolder;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider") // chỉ cho JpaAuditing tham chiếu tới Bean autitorProvider
public class JpaConfig {
	
	@Bean
	public AuditorAware<String> auditorProvider(){ // auditorProvider() tên mặc định
		return new AuditorAwareImpl();
	}
	
	//nested class => class nằm trong class => tạo 1 class nằm trong 1 class khác
	public class AuditorAwareImpl implements AuditorAware<String> {

		@Override
		public Optional<String> getCurrentAuditor() {
			String currentUsername = SecurityContextHolder.getContext()
										.getAuthentication().getName();
			
			return Optional.ofNullable(currentUsername);
		}
	}
}

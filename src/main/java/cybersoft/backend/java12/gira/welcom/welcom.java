package cybersoft.backend.java12.gira.welcom;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class welcom {
	
	@GetMapping("/welcom")
	public Object welcom() {
		return "Hello Minh Hiếu";
	}
}

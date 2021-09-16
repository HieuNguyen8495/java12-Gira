package cybersoft.backend.java12.gira.common;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jmx.export.metadata.JmxMetadataUtils;
import org.springframework.validation.BindingResult;

import cybersoft.backend.java12.gira.common.util.DateUtils;
import cybersoft.backend.java12.gira.common.util.ErrorsUtils;
import cybersoft.backend.java12.gira.role.entity.Program;

public class ResponseHandler {
	public static ResponseEntity<Object> getResponse(Object content, HttpStatus status){
		Map<String, Object> map = new HashMap<>();
		map.put("content", content);
		map.put("errors", "");
		map.put("timestamp", DateUtils.toString(LocalDateTime.now()));
		map.put("status", status.value());
		
		return new ResponseEntity<Object>(map, status);
		
	}
	
	public static ResponseEntity<Object> getResponse(BindingResult errors, HttpStatus status){
		Map<String, Object> map = new HashMap<>();
		map.put("content", "");
		map.put("errors", ErrorsUtils.getErrorMessage(errors));
		map.put("timestamp", DateUtils.toString(LocalDateTime.now()));
		map.put("status", status.value());
		
		return new ResponseEntity<Object>(map, status);
		
	}

	public static Object getResponse(HttpStatus status) {
		Map<String, Object> map = new HashMap<>();
		map.put("content", "");
		map.put("errors", "");
		map.put("timestamp", DateUtils.toString(LocalDateTime.now()));
		map.put("status", status.value());
		
		return new ResponseEntity<Object>(map, status);
	}
}

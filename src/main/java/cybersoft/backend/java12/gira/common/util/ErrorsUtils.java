package cybersoft.backend.java12.gira.common.util;

import java.util.LinkedList;
import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

public class ErrorsUtils {
	public static List<String> getErrorMessage(BindingResult errors){
		List<String> messages = new LinkedList<>();
		
		for(ObjectError err : errors.getAllErrors())
			messages.add(err.getDefaultMessage());
		
		return messages;
	}
}

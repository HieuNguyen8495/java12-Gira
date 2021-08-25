package cybersoft.backend.java12.gira.role.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cybersoft.backend.java12.gira.common.ResponseHandler;
import cybersoft.backend.java12.gira.dto.CreateGroupDto;
import cybersoft.backend.java12.gira.dto.GroupDto;
import cybersoft.backend.java12.gira.role.entity.Group;
import cybersoft.backend.java12.gira.role.service.itf.GroupService;

@RestController
@RequestMapping("/api/group")
public class GroupController {
	
	private GroupService service;
	
	public GroupController(GroupService groupService) {
		service = groupService;
	}
	
	@GetMapping
	public Object findAll() {
		List<GroupDto> groups = service.findAll();
		
		return ResponseHandler.getResponse(groups, HttpStatus.OK);
	}
	
	@PostMapping
	public Object addNewGroup(@Valid @RequestBody CreateGroupDto dto, BindingResult errors) {
		if(errors.hasErrors())
			return ResponseHandler.getResponse(errors, HttpStatus.BAD_REQUEST);
		
		Group newGroup = service.addNewGroup(dto);
		
		return ResponseHandler.getResponse(newGroup, HttpStatus.OK);
				
	}
}

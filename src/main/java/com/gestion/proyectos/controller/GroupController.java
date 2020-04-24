package com.gestion.proyectos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.proyectos.model.Group;
import com.gestion.proyectos.service.IGroupService;

@RestController
@RequestMapping("group")
public class GroupController {
	
	
	IGroupService groupService;
	
	@Autowired
	public GroupController (IGroupService groupService) {
		this.groupService = groupService;
	}
	
	@GetMapping
	public List<Group> getAllGroups() {
		return groupService.allGroups();
	}
	
	@PostMapping
	public Group addNewGroup(@RequestBody Group group) {
		return groupService.addGroups(group);
	}
	
}

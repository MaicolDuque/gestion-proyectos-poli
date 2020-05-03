package com.gestion.proyectos.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping("/{id}")
	public Group getGroup(@PathVariable Long id) {
		return groupService.getGroupById(id);
	}
	
	@PostMapping
	public Group addNewGroup(@RequestBody Group group) {
		return groupService.addGroups(group);
	}
	
	@PutMapping("/{id}")
	public Group updatedGroup(@PathVariable Long id, @RequestBody Group group) {
		return groupService.updateGroup(group, id);
	}

	@DeleteMapping("/{id}")
	public Group deleteGroup(@PathVariable Long id) {
		return groupService.deleteGroup(id);
	}	
	
}

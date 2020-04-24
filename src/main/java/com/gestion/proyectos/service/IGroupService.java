package com.gestion.proyectos.service;

import java.util.List;

import com.gestion.proyectos.model.Group;


public interface IGroupService {

	List<Group> allGroups();
	Group addGroups(Group group);
}

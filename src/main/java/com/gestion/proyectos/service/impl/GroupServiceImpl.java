package com.gestion.proyectos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.proyectos.repository.GroupRepository;
import com.gestion.proyectos.model.Group;
import com.gestion.proyectos.service.IGroupService;


@Service
public class GroupServiceImpl implements IGroupService{
	
	GroupRepository groupDao;
	
	@Autowired
	public  GroupServiceImpl(GroupRepository groupDao) {
		this.groupDao = groupDao;
	}
	
	@Override
	public List<Group> allGroups() {		
		return groupDao.findAll();
	}

	
	@Override
	public Group addGroups(Group group) {
		return groupDao.save(group);		
	}

	@Override
	public Group deleteGroup(Long id) {	
		Group grupo = getGroupById(id);
		groupDao.deleteById(id);
		return grupo;
	}

	@Override
	public Group getGroupById(Long id) {		
		return groupDao.findById(id).orElse(null);
	}

	@Override
	public Group updateGroup(Group newGroup, Long id) {		
		if(groupDao.findById(id).isPresent()) {
			return groupDao.save(newGroup);
		}
		return null;
	}

	
}

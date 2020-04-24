package com.gestion.proyectos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.proyectos.dao.IGroupDao;
import com.gestion.proyectos.model.Group;
import com.gestion.proyectos.service.IGroupService;


@Service
public class GroupServiceImpl implements IGroupService{
	
	IGroupDao groupDao;
	
	@Autowired
	public  GroupServiceImpl(IGroupDao groupDao) {
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

	
}

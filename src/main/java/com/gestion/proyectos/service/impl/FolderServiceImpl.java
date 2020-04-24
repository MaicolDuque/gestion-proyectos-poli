package com.gestion.proyectos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.proyectos.dao.IFolderDao;
import com.gestion.proyectos.model.Folder;
import com.gestion.proyectos.service.IFolderService;

@Service
public class FolderServiceImpl implements IFolderService {
	
	IFolderDao folderDao;
	
	
	@Autowired
	public FolderServiceImpl(IFolderDao folderDao) {
		this.folderDao = folderDao;
	}
	
	@Override
	public Folder addFolder(Folder folder) {		
		return folderDao.save(folder);
	}

	@Override
	public List<Folder> getAllFolders() {		
		return folderDao.findAll();
	}

}

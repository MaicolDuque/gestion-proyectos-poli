package com.gestion.proyectos.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.proyectos.repository.FolderRepository;
import com.gestion.proyectos.model.Folder;
import com.gestion.proyectos.service.IFolderService;

@Service
public class FolderServiceImpl implements IFolderService {
	
	FolderRepository folderDao;
	
	
	@Autowired
	public FolderServiceImpl(FolderRepository folderDao) {
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

	@Override
	public Folder deleteFolder(Long id) {
		Folder folder = getFolderById(id);
		folderDao.deleteById(id);
		return folder;
	}

	@Override
	public Folder getFolderById(Long id) {
		return folderDao.findById(id).orElse(null);
	}

	@Override
	public Folder updateFolder(Folder folder, Long id) {
		Optional<Folder> currentFolder = folderDao.findById(id);
		 if(currentFolder.isPresent()) {
			 Folder newFolder = currentFolder.get();
			 newFolder.setDescripcion(folder.getDescripcion());
			 newFolder.setNombre(folder.getNombre());
			 newFolder.setFecha(folder.getFecha());
			 newFolder.setGroup(folder.getGroup());
			 newFolder.setPadre(folder.getPadre());
			 //newFolder.setFiles(folder.getFiles());
			 return folderDao.save(newFolder);
		 }
		 return null;
	}

}

package com.gestion.proyectos.service;

import java.util.List;

import com.gestion.proyectos.model.Folder;

public interface IFolderService {
	Folder addFolder(Folder folder);
	Folder updateFolder(Folder folder, Long id);
	Folder deleteFolder(Long id);
	List<Folder> getAllFolders();
	Folder getFolderById(Long id);
}

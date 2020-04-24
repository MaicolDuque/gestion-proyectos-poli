package com.gestion.proyectos.service;

import java.util.List;

import com.gestion.proyectos.model.Folder;

public interface IFolderService {
	Folder addFolder(Folder folder);
	List<Folder> getAllFolders();
}

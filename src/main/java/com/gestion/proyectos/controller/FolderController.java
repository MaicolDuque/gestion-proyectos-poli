package com.gestion.proyectos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.proyectos.model.Folder;
import com.gestion.proyectos.service.IFolderService;

@RestController
@RequestMapping("folder")
public class FolderController {
	
	IFolderService folderService;
	
	@Autowired
	public FolderController(IFolderService folderService) {
		this.folderService = folderService;
	}
	
	@GetMapping
	public List<Folder> getAllFolders(){
		return folderService.getAllFolders();
	}
	
	@GetMapping("/{id}")
	public Folder getFolderById(@PathVariable Long id){
		return folderService.getFolderById(id);
	}

	@PostMapping
	public Folder addNewFolder(@RequestBody Folder folder) {
		return folderService.addFolder(folder);
	}

	@PutMapping("/{id}")
	public Folder updateFolder(@PathVariable Long id, @RequestBody Folder folder) {
		return folderService.updateFolder(folder, id);
	}

	@DeleteMapping("/{id}")
	public Folder deleteFolder(@PathVariable Long id) {
		return folderService.deleteFolder(id);
	}
}

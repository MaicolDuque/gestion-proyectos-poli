package com.gestion.proyectos.controller;

import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import com.gestion.proyectos.repository.FolderRepository;
import com.gestion.proyectos.service.IFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import com.gestion.proyectos.model.Folder;
import com.gestion.proyectos.service.IFolderService;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("folder")
public class FolderController {
	private final String FILE_BASE_PATH = "./descargas/";

	private final IFolderService folderService;
	private final FolderRepository folderRepository;
	private final IFileService fileService;
	
	@Autowired
	public FolderController(
			IFolderService folderService,
			FolderRepository folderRepository,
			IFileService fileService
	) {
		this.folderService = folderService;
		this.folderRepository = folderRepository;
		this.fileService = fileService;
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

	@PostMapping("/{id}")
	public Boolean uploadFileToFolder(@PathVariable Long id, @RequestParam("file") MultipartFile file) {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		Path path = Paths.get(FILE_BASE_PATH + fileName);
		Folder folder = folderService.getFolderById(id);
		boolean uploadState = false;

		if (folder == null ) {
			System.out.println("Folder no encontrado ERROR");
			return false;
		} else {
			try {
				uploadState = fileService.uploadFile(file.getInputStream(),path, StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return uploadState;
	}
}

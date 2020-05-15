package com.gestion.proyectos.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.gestion.proyectos.acl.exception.MyFileNotFoundException;
import com.gestion.proyectos.acl.http.UploadFileResponse;
import com.gestion.proyectos.model.File;
import com.gestion.proyectos.model.Folder;
import com.gestion.proyectos.repository.FileRepository;
import com.gestion.proyectos.service.IFileService;
import com.gestion.proyectos.service.IFolderService;
import com.gestion.proyectos.service.impl.FileStorageService;
import com.google.gson.JsonObject;
import io.vavr.control.Option;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("files")
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    private final FileStorageService fileStorageService;
    private final IFolderService folderService;
    private final IFileService fileService;
    private final FileRepository fileRepository;

    public FileController(FileStorageService fileStorageService, IFolderService folderService, FileRepository fileRepository, IFileService fileService) {
        this.fileStorageService = fileStorageService;
        this.folderService = folderService;
        this.fileRepository = fileRepository;
        this.fileService = fileService;
    }

    @PostMapping("/{id}")
    public UploadFileResponse uploadFile(@PathVariable Long id,@RequestParam("file") MultipartFile file) {
        Folder folder = folderService.getFolderById(id);

        if (folder == null) throw new MyFileNotFoundException("Folder: " + id + " doesn't exist");

        String fileName = fileStorageService.storeFile(file,id);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/files/downloadFile/")
                .path(fileName)
                .toUriString();

        List<File> files = folder.getFiles();

        //Esta linea se hizo para manejar las listas mas facil
        io.vavr.collection.List<File> listVavr = io.vavr.collection.List.ofAll(files);

        Option<File> fileOption = listVavr.find(f -> f.getNombre().equals(fileName));

        io.vavr.collection.List<File> allFiles = fileOption.map(
                f -> listVavr.map(
                        f2 -> {
                            if (f2.getNombre().equals(f.getNombre())) {
                                return f;
                            } else {
                                return f2;
                            }
                        }
                )).getOrElse(listVavr.append(new File(fileName, fileDownloadUri, folder)));

        allFiles.map(fileRepository::save);

        return new UploadFileResponse(fileName, fileDownloadUri, file.getContentType(), file.getSize());
    }

    @GetMapping("/downloadFile/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        Resource resource = fileStorageService.loadFileAsResource(fileName);

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            logger.info("Could not determine file type.");
        }

        // Fallback to the default content type if type could not be determined
        if(contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }


    @DeleteMapping("/{id}")
    public JsonNode deleteFileById(@PathVariable Long id){
        return fileService.deleteFile(id);
    }

}

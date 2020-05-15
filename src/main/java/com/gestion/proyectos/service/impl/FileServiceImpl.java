package com.gestion.proyectos.service.impl;

import com.gestion.proyectos.model.File;
import com.gestion.proyectos.repository.FileRepository;
import com.gestion.proyectos.service.IFileService;
import org.mapstruct.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Optional;
import java.util.UUID;

@Service
public class FileServiceImpl implements IFileService {

    FileRepository fileDao;
    private final FileStorageService fileStorageService;

    @Autowired
    public FileServiceImpl(FileRepository fileDao, FileStorageService fileStorageService){
        this.fileDao = fileDao;
        this.fileStorageService = fileStorageService;
    }

    @Override
    public boolean uploadFile(InputStream in, Path path, CopyOption copyOption) {
        try {
            Files.copy(in, path, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public String createFileName() {
        return UUID.randomUUID().toString();
    }


    @Override
    public String deleteFile(Long id) {
        if(getFileById(id).isPresent()){
            File file = getFileById(id).get();
            fileStorageService.deleteFile(file.getNombre());
            fileDao.deleteById(id);
            return "S";
        }
        return "No existe archivo con el id: "+id;
    }

    @Override
    public Optional<File> getFileById(Long id) {
        return fileDao.findById(id);
    }
}

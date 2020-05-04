package com.gestion.proyectos.service.impl;

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
import java.util.UUID;

@Service
public class FileServiceImpl implements IFileService {

    FileRepository fileDao;

    @Autowired
    public FileServiceImpl(FileRepository fileDao){ this.fileDao = fileDao; }

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
        fileDao.deleteById(id);
        return "S";
    }
}

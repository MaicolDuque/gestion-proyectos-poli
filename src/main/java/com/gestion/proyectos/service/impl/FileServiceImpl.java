package com.gestion.proyectos.service.impl;

import com.gestion.proyectos.service.IFileService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

@Service
public class FileServiceImpl implements IFileService {
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
}

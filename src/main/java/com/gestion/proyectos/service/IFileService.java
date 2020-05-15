package com.gestion.proyectos.service;

import com.gestion.proyectos.model.File;

import java.io.InputStream;
import java.nio.file.CopyOption;
import java.nio.file.Path;
import java.util.Optional;

public interface IFileService {
    boolean uploadFile(InputStream in, Path path, CopyOption copyOption);
    String createFileName();
    String deleteFile(Long id);
    Optional<File> getFileById(Long id);
}

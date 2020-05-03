package com.gestion.proyectos.service;

import java.io.InputStream;
import java.nio.file.CopyOption;
import java.nio.file.Path;

public interface IFileService {
    boolean uploadFile(InputStream in, Path path, CopyOption copyOption);
}

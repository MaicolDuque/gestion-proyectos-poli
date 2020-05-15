package com.gestion.proyectos.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.gestion.proyectos.model.File;
import com.google.gson.JsonObject;
import org.json.JSONObject;

import java.io.InputStream;
import java.nio.file.CopyOption;
import java.nio.file.Path;
import java.util.Optional;

public interface IFileService {
    boolean uploadFile(InputStream in, Path path, CopyOption copyOption);
    String createFileName();
    JsonNode deleteFile(Long id);
    Optional<File> getFileById(Long id);
}

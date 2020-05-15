package com.gestion.proyectos.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gestion.proyectos.model.File;
import com.gestion.proyectos.repository.FileRepository;
import com.gestion.proyectos.service.IFileService;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.json.JSONObject;
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
    public JsonNode deleteFile(Long id) {
        JsonNode correct = null;
        JsonNode incorrect = null;
        try {
            String json = "{\"respuesta\":\"S\" }";
            String json2 = "{\"respuesta\":\"N\" }";
            ObjectMapper mapper = new ObjectMapper();
            correct = mapper.readTree(json);
            incorrect = mapper.readTree(json2);
        }catch (Exception ex){
            ex.printStackTrace();
        }

        if(getFileById(id).isPresent()){
            File file = getFileById(id).get();
            fileStorageService.deleteFile(file.getNombre());
            fileDao.deleteById(id);
            return correct;
        }
        return incorrect;
    }

    @Override
    public Optional<File> getFileById(Long id) {
        return fileDao.findById(id);
    }
}

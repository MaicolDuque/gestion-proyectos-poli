package com.gestion.proyectos.dao;



import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.proyectos.model.File;

public interface IFileDao extends JpaRepository<File, Long> {

}

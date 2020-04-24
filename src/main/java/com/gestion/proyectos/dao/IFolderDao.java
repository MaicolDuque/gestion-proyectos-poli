package com.gestion.proyectos.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.proyectos.model.Folder;

public interface IFolderDao extends JpaRepository<Folder, Long>{

}

package com.gestion.proyectos.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.proyectos.model.Folder;


@Repository
public interface IFolderDao extends JpaRepository<Folder, Long>{

}

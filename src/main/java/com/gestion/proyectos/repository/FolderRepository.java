package com.gestion.proyectos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.proyectos.model.Folder;


@Repository
public interface FolderRepository extends JpaRepository<Folder, Long>{

}

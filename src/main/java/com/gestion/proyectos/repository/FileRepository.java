package com.gestion.proyectos.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.proyectos.model.File;

public interface FileRepository extends JpaRepository<File, Long> {

}

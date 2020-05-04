package com.gestion.proyectos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.proyectos.model.Group;


@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

}

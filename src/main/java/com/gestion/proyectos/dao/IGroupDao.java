package com.gestion.proyectos.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.proyectos.model.Group;


@Repository
public interface IGroupDao extends JpaRepository<Group, Long> {

}

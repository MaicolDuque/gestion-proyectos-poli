package com.gestion.proyectos.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.proyectos.model.Group;

public interface IGroupDao extends JpaRepository<Group, Long> {

}

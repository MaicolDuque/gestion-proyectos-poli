package com.gestion.proyectos.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

@Entity
@Data
@Table(name="groups")
public class Group implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String descripcion;
	private Date fecha;
	
	
	@JsonManagedReference
	@OneToMany(
	        mappedBy = "group",
	        cascade = CascadeType.ALL,
	        orphanRemoval = true
	        )
	private List<Folder> folders = new ArrayList<>();
	
	
	public Group() {
		
	}

	public Group(Long id, String nombre, String descripcion, Date fecha) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fecha = fecha;
	}
	
}

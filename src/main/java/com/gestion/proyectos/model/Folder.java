package com.gestion.proyectos.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name ="folders")
public class Folder implements Serializable {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long idPadre;
	
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)    
    private Group group; 
	
	@JsonManagedReference
	@OneToMany(
	        mappedBy = "folder",
	        cascade = CascadeType.ALL,
	        orphanRemoval = true
	        )
	private List<File> files = new ArrayList<>();
	
	
	private String nombre;
	private String descripcion;	
	private Date fecha;
	
	public Folder() {
	
	}
		
	public Folder(Long id, Long idPadre, String nombre, String descripcion, Date fecha) {	
		this.id = id;
		this.idPadre = idPadre;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fecha = fecha;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdPadre() {
		return idPadre;
	}

	public void setIdPadre(Long idPadre) {
		this.idPadre = idPadre;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public List<File> getFiles() {
		return files;
	}

	public void setFiles(List<File> files) {
		this.files = files;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
	
	



	
	
	
	
	
	
	
	
}

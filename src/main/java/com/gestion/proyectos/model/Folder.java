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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Data
@Table(name ="folders")
public class Folder implements Serializable {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long padre;
	
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "group_id", nullable = false)
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
		
	public Folder(Long idPadre, String nombre, String descripcion, Date fecha, Group group) {
		this.padre = idPadre;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.group = group;
	}

	@Override
	public String toString() {
		return "Folder [id=" + id + ", padre=" + padre + ", group=" + group + ", files=" + files + ", nombre=" + nombre
				+ ", descripcion=" + descripcion + ", fecha=" + fecha + "]";
	}
	
	
	



	
	
	
	
	
	
	
	
}

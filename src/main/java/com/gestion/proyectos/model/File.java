package com.gestion.proyectos.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

@Entity
@Data
@Table(name="files")
public class File implements Serializable {
	
    private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	private String nombre;
	private String filePath;
	private Date fecha;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)    
    private Folder folder; 

	public File() {
		super();
	}

	
	public File(String nombre, String filePath,Folder folder) {
		super();
		this.filePath = filePath;
		this.nombre = nombre;
		this.folder = folder;
		this.fecha = new Date(Calendar.getInstance().getTime().getTime());
	}

}

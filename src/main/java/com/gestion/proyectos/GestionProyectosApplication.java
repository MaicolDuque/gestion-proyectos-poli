package com.gestion.proyectos;

import com.gestion.proyectos.configuracion.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
		FileStorageProperties.class
})
public class GestionProyectosApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionProyectosApplication.class, args);
	}

}

package com.gestion.proyectos;

import com.gestion.proyectos.configuracion.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableConfigurationProperties({
		FileStorageProperties.class
})
public class GestionProyectosApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionProyectosApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
				 .allowedOrigins("*")
				 .allowedMethods("*");
			}
		};
	}



}

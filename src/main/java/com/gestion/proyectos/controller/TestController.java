package com.gestion.proyectos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@GetMapping("/test")
	public String prueba() {
		return "Controller of the test!";
	}
}

package com.capgemini.projetospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller	
public class HomeController {
	
	@GetMapping("/")
	public String iniciar() {
		return "index";
	}
	
	
}
	
package com.capgemini.projetospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller	
public class HomeController {
	
	@GetMapping("/")
	public String iniciar() {
		return "index";
	}
	
	@GetMapping("/conteudo")
	public String mostrar(Model model) {
		double numero = Math.random();
		model.addAttribute("mensagem", "Número gerado: " + numero);
		//model.addAttribute("mensagem", "Apresentando a parametrização do Spring Boot");
		return "conteudo";
	}
	
	
}
	
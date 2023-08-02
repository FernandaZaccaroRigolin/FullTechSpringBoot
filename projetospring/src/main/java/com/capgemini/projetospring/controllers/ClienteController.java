package com.capgemini.projetospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClienteController {

	@GetMapping("/clientes/novo")
	public ModelAndView incluir() {
		try {
			return new ModelAndView("clientes/novoCliente");
		} catch (Exception e) {
			return new ModelAndView("erro", "msg_erro", e.toString());
		}

	}
}

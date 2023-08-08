package com.capgemini.projetospring.controllers.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.projetospring.dto.ClienteDTO;
import com.capgemini.projetospring.models.Cliente;
import com.capgemini.projetospring.services.ClienteService;

@RestController
@RequestMapping("/api/clientes")
public class ApiClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/todos")
	public List<Cliente> listarTodos() {
		return clienteService.listarClientes();
	}

	@GetMapping("/")
	public List<ClienteDTO> listarTodosDTO() {
		return clienteService.listarClientesDTO();
	}	
}

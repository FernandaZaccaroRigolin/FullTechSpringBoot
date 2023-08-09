package com.capgemini.projetospring.controllers.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@CrossOrigin
	@GetMapping("/")
	public List<ClienteDTO> listarTodosDTO() {
		return clienteService.listarClientesDTO();
	}	
	
	@GetMapping("/{cpf}")
	public ClienteDTO buscarCliente(@PathVariable String cpf) {
		return clienteService.buscarCliente(cpf);
	}
	
	@PostMapping("/")
	public Cliente incluirCliente(@RequestBody Cliente cliente) {
//		try {
//			return clienteService.incluir(cliente);
//		} catch (Exception e) {
//			return null;
//		}
		return clienteService.incluir(cliente);
	}
	
	@PutMapping("/{cpf}")
	public Cliente alterarCliente(@RequestBody Cliente cliente, @PathVariable String cpf) {
		return clienteService.alterar(cliente, cpf);
	}
	
	@DeleteMapping("/{cpf}")
	public ResponseEntity<String> deleteCliente(@PathVariable String cpf) {
		return new ResponseEntity<String>(clienteService.remover(cpf), HttpStatus.ACCEPTED);
		
	}
	
}

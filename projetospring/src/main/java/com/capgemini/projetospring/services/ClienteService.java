package com.capgemini.projetospring.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.projetospring.dto.ClienteDTO;
import com.capgemini.projetospring.models.Cliente;
import com.capgemini.projetospring.repository.ClienteRepository;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<Cliente> listarClientes() {
		return clienteRepository.findAll();
	}
	
	public List<ClienteDTO> listarClientesDTO() {
		List<ClienteDTO> clientes = new ArrayList<ClienteDTO>();
		clienteRepository.findAll().forEach(c -> 
			clientes.add(new ClienteDTO(c.getCpf(), c.getNome(), c.getTelefone(), c.getEmail())));
		
		return clientes;
		
	}

}

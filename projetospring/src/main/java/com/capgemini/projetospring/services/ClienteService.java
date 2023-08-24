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

	public ClienteDTO buscarCliente(String cpf) {
		Cliente cliente = clienteRepository.getReferenceById(cpf);
		return new ClienteDTO(
					cliente.getCpf(), 
					cliente.getNome(), 
					cliente.getTelefone(),
					cliente.getEmail());
	}
	
	public Cliente incluir(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public Cliente alterar(Cliente cliente, String cpf) {
//		Cliente c = clienteRepository.getReferenceById(cpf);
//		if (c == null) {
//			throw new EntityNotFoundException("O cliente a ser alterar não existe. ");
//		}
		cliente.setCpf(cpf);
		return clienteRepository.save(cliente);
	}
	
	public String remover(String cpf) {
		try {
			clienteRepository.deleteById(cpf);
			return String.format("Cliente %s removido com sucesso", cpf);
		} catch (Exception e) {
			return e.toString();
		}
	}
}

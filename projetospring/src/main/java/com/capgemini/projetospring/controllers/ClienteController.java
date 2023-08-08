package com.capgemini.projetospring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.capgemini.projetospring.models.Cliente;
import com.capgemini.projetospring.repository.ClienteRepository;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping("/novo")
	public ModelAndView incluir() {
		try {
			return new ModelAndView("clientes/novoCliente");
		} catch (Exception e) {
			return new ModelAndView("erro", "msg_erro", e.toString());
		}

	}
	
	@PostMapping("/novo")
	public String incluir(Cliente cliente, Model model) {
		try {
			clienteRepository.save(cliente);
			
			//System.out.println(cliente);
			return "redirect:/clientes/lista";
		} catch (Exception e) {
			model.addAttribute("msg_erro", e.toString());
			return "erro";
		}
	}
	
	@GetMapping("/lista")
	public ModelAndView listar() {
		try {
			List<Cliente> clientes = clienteRepository.findAll();
			return new ModelAndView("clientes/listaClientes", "listagem_clientes", clientes);
		} catch (Exception e) {
			return new ModelAndView("erro", "msg_erro", e.toString());
		}
	}
	
	// alterando dados do cliente
	@GetMapping("/alterar/{doc}")
	public ModelAndView alterar(@PathVariable("doc") String cpf) {
		try {
			Cliente cliente = clienteRepository.getReferenceById(cpf);
			return new ModelAndView("clientes/alterarCliente", "cliente", cliente);
			
		} catch (Exception e) {
			return new ModelAndView("erro", "msg_erro", e.toString());
		}
		
	}
	
	@PostMapping("/alterar")
	public String alterar(Cliente cliente, Model model) {
		try {
			clienteRepository.save(cliente);
			
			//System.out.println(cliente);
			return "redirect:/clientes/lista";
		} catch (Exception e) {
			model.addAttribute("msg_erro", e.toString());
			return "erro";
		}
	}
	
	// excluindo dados do cliente
	@GetMapping("/remover/{doc}")
	public ModelAndView remover(@PathVariable("doc") String cpf) {
		try {
			Cliente cliente = clienteRepository.getReferenceById(cpf);
			return new ModelAndView("clientes/removerCliente", "cliente", cliente);
			
		} catch (Exception e) {
			return new ModelAndView("erro", "msg_erro", e.toString());
		}
		
	}	
	
	@PostMapping("/remover")
	public String remover(@RequestParam("cpf") String cpf, Model model) {
		try {
			clienteRepository.deleteById(cpf);
			return "redirect:/clientes/lista";
		} catch (Exception e) {
			model.addAttribute("msg_erro", e.toString());
			return "erro";
		}
	}	
	
}

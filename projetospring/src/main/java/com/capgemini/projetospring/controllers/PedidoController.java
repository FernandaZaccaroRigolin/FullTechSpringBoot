package com.capgemini.projetospring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.capgemini.projetospring.models.Cliente;
import com.capgemini.projetospring.models.Pedido;
import com.capgemini.projetospring.repository.ClienteRepository;
import com.capgemini.projetospring.repository.PedidoRepository;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;	
	
	@GetMapping("/novo")
	public ModelAndView incluir() {
		try {
			List<Cliente> clientes = clienteRepository.findAll();
			return new ModelAndView("pedidos/efetuarPedido", "lista_clientes", clientes);
		} catch (Exception e) {
			return new ModelAndView("erro", "msg_erro", e.toString());
		}
	}
	
	@PostMapping("/novo")
	public String incluir(@RequestParam("cpf") String cpf, Pedido pedido, Model model) {
		try {
			Cliente cliente = clienteRepository.getReferenceById(cpf);
			pedido.setCliente(cliente);
			pedidoRepository.save(pedido);
			return "redirect:/";
		} catch (Exception e) {
			model.addAttribute("msg_erro", e.toString());
			return "erro";
		}
	}	

}

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

import com.capgemini.projetospring.dto.ClientePedidosDTO;
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
	
	@GetMapping("/todos")
	public ModelAndView listarTodos() {
		try {
			List<ClientePedidosDTO> todosPedidos = pedidoRepository.getClientePedidosDTO();
			return new ModelAndView("pedidos/listaTodosPedidos", "todos_pedidos", todosPedidos);
		} catch (Exception e) {
			return new ModelAndView("erro", "msg_erro", e.toString());
		}
	}
	
	@GetMapping(path = {"/lista", "/lista/{cpf}"})
	public ModelAndView listarPedidos(@PathVariable(name = "cpf", required = false) String cpf) {
		try {
			
			List<ClientePedidosDTO> pedidos;
			if (cpf != null) {
				pedidos = pedidoRepository.getClientePedidosDTOByCpf(cpf);
			} else {
				pedidos = pedidoRepository.getClientePedidosDTO();
			}

			return new ModelAndView("pedidos/listaPedidos", "lista_pedidos", pedidos);
			
		} catch (Exception e) {
			return new ModelAndView("erro", "msg_erro", e.toString());
		}
		
	}
	
	@GetMapping("/pedidos")
	public ModelAndView listar() {
		try {
			List<Pedido> pedidos = pedidoRepository.findAll();
			return new ModelAndView("pedidos/listagemPedidos", "listagem_pedidos", pedidos);
		} catch (Exception e) {
			return new ModelAndView("erro", "msg_erro", e.toString());
		}
	}	

}

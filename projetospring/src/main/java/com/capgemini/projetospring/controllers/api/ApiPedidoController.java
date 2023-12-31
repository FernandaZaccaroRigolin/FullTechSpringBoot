package com.capgemini.projetospring.controllers.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.projetospring.dto.ClientePedidosDTO;
import com.capgemini.projetospring.dto.PedidoClienteDTO;
import com.capgemini.projetospring.dto.PedidoDTO;
import com.capgemini.projetospring.models.Pedido;
import com.capgemini.projetospring.services.PedidoService;

@RestController
@RequestMapping("/api/pedidos")
public class ApiPedidoController {

	@Autowired
	private PedidoService pedidoService;
	
	@PostMapping("/")
	public Pedido incluirPedido(@RequestBody Map<String, String> dados) {
		try {
			return pedidoService.incluirPedido(dados);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@CrossOrigin
	@PostMapping("/dto")
	public ResponseEntity<?> incluirPedidoDTO(@RequestBody Map<String, String> dados) {
		try {
			return new ResponseEntity<PedidoClienteDTO>(
					pedidoService.incluirPedidoDTO(dados),
					HttpStatus.CREATED);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}		
	}	
	
	
	// action para incluir um pedido usando DTO
	@PostMapping("/incluir")
	public Pedido incluirPedido(@RequestBody PedidoDTO pedido) {
		try {
			return pedidoService.incluirPedido(pedido);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
	@CrossOrigin
	@GetMapping(path = { "/", "/{cpf}"})
	public List<ClientePedidosDTO> listarPedidos(
			@PathVariable(name = "cpf", required = false) String cpf) {
		try {
			if(cpf != null) {
				return pedidoService.listarPedidos(cpf);
			} else {
				return pedidoService.listarPedidos();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
	@GetMapping("/lista")
	public List<Pedido> listar() {
		return pedidoService.listarPedidosId();
	}
}






package com.capgemini.projetospring.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.projetospring.dto.ClienteDTO;
import com.capgemini.projetospring.dto.ClientePedidosDTO;
import com.capgemini.projetospring.dto.PedidoClienteDTO;
import com.capgemini.projetospring.dto.PedidoDTO;
import com.capgemini.projetospring.models.Cliente;
import com.capgemini.projetospring.models.Pedido;
import com.capgemini.projetospring.repository.ClienteRepository;
import com.capgemini.projetospring.repository.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ClienteService clienteService;
	
	
	public Pedido incluirPedido(Map<String, String> dados) throws ParseException {
		
		// obtendo os dados através da coleção Map:
		String cpf = dados.get("cpf");
		String npedido = dados.get("pedido");
		String data = dados.get("data");
		
		// obtendo o cliente com base no cpf
		Cliente c = clienteRepository.getReferenceById(cpf);
		
		// obtendo o objeto Date com base na data fornecida
		Date dataPedido = new SimpleDateFormat("yyyy-MM-dd").parse(data);
		
		// criando o objeto Pedido
		Pedido pedido = new Pedido();
		pedido.setCliente(c);
		pedido.setData(dataPedido);
		pedido.setNumeroPedido(npedido);
		
		pedidoRepository.save(pedido);
		
		return pedido;
	}
	
	public Pedido incluirPedido(PedidoDTO dados) throws ParseException {
		// obtendo o cliente com base no cpf
		Cliente c = clienteRepository.getReferenceById(dados.getCpf());
		
		// obtendo o objeto Date com base na data fornecida
		Date dataPedido = new SimpleDateFormat("yyyy-MM-dd").parse(dados.getData());
		
		// criando o objeto Pedido
		Pedido pedido = new Pedido();
		pedido.setCliente(c);
		pedido.setData(dataPedido);
		pedido.setNumeroPedido(dados.getPedido());
		
		pedidoRepository.save(pedido);
		
		return pedido;		
	}
	
	public PedidoClienteDTO incluirPedidoDTO(Map<String, String> dados) throws ParseException {
		
		String cpf = dados.get("cpf");
		String npedido = dados.get("pedido");
		String data = dados.get("data");
		
		Cliente c = clienteRepository.getReferenceById(cpf);
		ClienteDTO dto = clienteService.buscarCliente(cpf);
		
		Date dataPedido = new SimpleDateFormat("yyyy-MM-dd").parse(data);
		
		Pedido pedido = new Pedido();
		pedido.setCliente(c);
		pedido.setData(dataPedido);
		pedido.setNumeroPedido(npedido);
		
		pedidoRepository.save(pedido);
		
		PedidoClienteDTO pedidoDTO = new 
			PedidoClienteDTO(pedido.getId(), pedido.getData(), pedido.getNumeroPedido(), dto);
		
		return pedidoDTO;
	}
	
	
	// listando os pedidos
	public List<ClientePedidosDTO> listarPedidos() {
		return pedidoRepository.getClientePedidosDTO();
	}
	
	public List<ClientePedidosDTO> listarPedidos(String cpf) {
		return pedidoRepository.getClientePedidosDTOByCpf(cpf);
	}
	
	
	
	public List<Pedido> listarPedidosId(){
		return pedidoRepository.findAll();
	}
}










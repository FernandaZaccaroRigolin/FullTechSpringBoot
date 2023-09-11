package com.capgemini.projetospring.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.projetospring.dto.FaturaDTO;
import com.capgemini.projetospring.dto.ItensPedidoDTO;

@Service
public class FaturaService {

	private final ItemService itemService;
	
	public FaturaService(ItemService itemService) {
		this.itemService = itemService;
	}
	
	
	public FaturaDTO buscarPedido(int idPedido, String cartao) {
		List<ItensPedidoDTO> itens = itemService.listarItens(idPedido);
		double totalItens = itens.stream().mapToDouble(p -> p.getValorItem()).sum();
		
		FaturaDTO faturaDTO = new FaturaDTO();
		faturaDTO.setIdPedido(idPedido);
		faturaDTO.setNumeroCartao(cartao);
		faturaDTO.setValor(totalItens);
		faturaDTO.setStatus(1); // pendente
		
		return faturaDTO;
	}
}


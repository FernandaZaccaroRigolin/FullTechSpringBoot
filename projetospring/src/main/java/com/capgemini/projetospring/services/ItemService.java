package com.capgemini.projetospring.services;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.projetospring.models.Item;
import com.capgemini.projetospring.models.Pedido;
import com.capgemini.projetospring.models.Produto;
import com.capgemini.projetospring.repository.ItemRepository;
import com.capgemini.projetospring.repository.PedidoRepository;
import com.capgemini.projetospring.repository.ProdutoRepository;

@Service
public class ItemService {
	@Autowired
	private ItemRepository itemRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public Item adicionarItem(Map<String, String> dados) {
		/*
		 * esperamos um objeto com as propriedades:
		 * 
		 * - idpedido
		 * - idproduto
		 * - quantidade
		 */
		int idpedido = Integer.parseInt(dados.get("idpedido"));
		int idproduto = Integer.parseInt(dados.get("idproduto"));
		Double quantidade = Double.parseDouble(dados.get("quantidade"));
		
		Pedido pedido = pedidoRepository.getReferenceById(idpedido);
		Produto produto = produtoRepository.getReferenceById(idproduto);
		
		double preco =  produto.getPreco() * quantidade; 
		
		Item item = new Item();
		
		item.setPedido(pedido);
		item.setProduto(produto);
		item.setQuantidade(quantidade);
		item.setPreco(preco);
		
		itemRepository.save(item);
		
		return item;
	}
}


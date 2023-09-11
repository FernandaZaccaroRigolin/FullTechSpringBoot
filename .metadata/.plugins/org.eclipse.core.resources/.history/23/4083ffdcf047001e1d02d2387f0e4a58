package com.capgemini.projetospring.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.projetospring.dto.ItemDTO;
import com.capgemini.projetospring.dto.ItensPedidoDTO;
import com.capgemini.projetospring.dto.PedidoItemDTO;
import com.capgemini.projetospring.dto.ProdutoDTO;
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
	
	
	public String adicionarItem(Map<String, String> dados) {
		/*
		 * esperamos um objeto com as propriedades:
		 * - idpedido, idproduto, quantidade
		 */
		int idpedido = Integer.parseInt(dados.get("idpedido"));
		int idproduto = Integer.parseInt(dados.get("idproduto"));
		double quantidade = Double.parseDouble(dados.get("quantidade"));
		
		Pedido pedido = pedidoRepository.getReferenceById(idpedido);
		Produto produto = produtoRepository.getReferenceById(idproduto);
		
		double preco = produto.getPreco() * quantidade;
		
		Item item = new Item();
		
		item.setPedido(pedido);
		item.setProduto(produto);
		item.setQuantidade(quantidade);
		item.setPreco(preco);
		
		itemRepository.save(item);
		
		
		
		return "Item incluído com sucesso";
	}

	public ItemDTO adicionarItemDTO(Map<String, String> dados) {
		/*
		 * esperamos um objeto com as propriedades:
		 * - idpedido, idproduto, quantidade
		 */
		int idpedido = Integer.parseInt(dados.get("idpedido"));
		int idproduto = Integer.parseInt(dados.get("idproduto"));
		double quantidade = Double.parseDouble(dados.get("quantidade"));
		
		Pedido pedido = pedidoRepository.getReferenceById(idpedido);
		Produto produto = produtoRepository.getReferenceById(idproduto);
		
		double preco = produto.getPreco() * quantidade;
		
		Item item = new Item();
		
		item.setPedido(pedido);
		item.setProduto(produto);
		item.setQuantidade(quantidade);
		item.setPreco(preco);
		
		itemRepository.save(item);
		
		// criando os objetos para o retorno
		PedidoItemDTO pedidoDTO = new PedidoItemDTO(
				pedido.getId(), 
				pedido.getNumeroPedido(), 
				pedido.getData());
		
		ProdutoDTO produtoDTO = new ProdutoDTO(
				produto.getId(), 
				produto.getDescricao(), 
				produto.getUnidade(), 
				produto.getPreco());
		
		ItemDTO itemDTO = new ItemDTO(
				item.getId(), 
				item.getPreco(), 
				item.getQuantidade(), 
				pedidoDTO, produtoDTO);
		
		return itemDTO;
	}
	
	
	public List<ItensPedidoDTO> listarItens() {
		return itemRepository.getItensPedidoDTO();
	}
}






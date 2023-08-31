package com.capgemini.projetospring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capgemini.projetospring.dto.ItensPedidoDTO;
import com.capgemini.projetospring.models.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{

	
	@Query("SELECT new com.capgemini.projetospring.dto.ItensPedidoDTO("
			+ "it.id, ped.numeroPedido, it.preco, it.quantidade, prod.descricao) "
			+ "FROM Pedido ped, Item it, Produto prod WHERE "
			+ "ped.id = it.pedido.id AND prod.id = it.produto.id")
	List<ItensPedidoDTO> getItensPedidoDTO();
<<<<<<< HEAD
	
	@Query("SELECT new com.capgemini.projetospring.dto.ItensPedidoDTO("
			+ "it.id, ped.numeroPedido, it.preco, it.quantidade, prod.descricao) "
			+ "FROM Pedido ped, Item it, Produto prod WHERE "
			+ "ped.id = it.pedido.id AND prod.id = it.produto.id AND ped.id = ?1")
	List<ItensPedidoDTO> getItensPedidoDTObyIdPedido(int id);	
	
=======
>>>>>>> 0741fdd8ac7f6eaeba8daf2efb43462e0d4ba51e
}

package com.capgemini.projetospring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capgemini.projetospring.dto.ItensPedidoDTO;
import com.capgemini.projetospring.models.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{
	
	@Query("SELECT new com.capgemini.projetospring.dto.ItensPedidoDTO( "
		    + "it.id, ped.numeroPedido, it.preco, it.quantidade, prod.descricao) "
		    + "FROM Pedido ped, Item it, Produto prod WHERE "
		    + "ped.id = it.pedido.id AND prod.id = it.produto.id")
	List<ItensPedidoDTO> getItensPedidoDTO();
	
}

//@Query("SELECT new com.capgemini.projetospring.dto.ClientePedidosDTO("
//		+ "p.id, c.cpf, c.nome, p.numeroPedido, p.data) FROM Cliente c "
//		+ "INNER JOIN c.pedidos p WHERE c.cpf = ?1")
//List<ClientePedidosDTO> getClientePedidosDTOByCpf(String cpf);	
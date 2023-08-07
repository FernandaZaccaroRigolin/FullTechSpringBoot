package com.capgemini.projetospring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capgemini.projetospring.dto.ClientePedidosDTO;
import com.capgemini.projetospring.models.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer>{

	@Query("SELECT new com.capgemini.projetospring.dto.ClientePedidosDTO("
			+ "p.id, c.cpf, c.nome, p.numeroPedido, p.data) FROM Cliente c INNER JOIN c.pedidos p")
	List<ClientePedidosDTO> getClientePedidosDTO();
	
	@Query("SELECT new com.capgemini.projetospring.dto.ClientePedidosDTO("
			+ "p.id, c.cpf, c.nome, p.numeroPedido, p.data) FROM Cliente c "
			+ "INNER JOIN c.pedidos p WHERE c.cpf = ?1")
	List<ClientePedidosDTO> getClientePedidosDTOByCpf(String cpf);	
	


}

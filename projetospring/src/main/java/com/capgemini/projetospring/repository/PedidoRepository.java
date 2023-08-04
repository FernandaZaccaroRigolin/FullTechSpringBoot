package com.capgemini.projetospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.projetospring.models.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer>{

}

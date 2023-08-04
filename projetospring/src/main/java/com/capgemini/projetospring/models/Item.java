package com.capgemini.projetospring.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_itens")
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "PRECO")
	private Double preco;
	
	@Column(name = "QUANTIDADE")
	private Double quantidade;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDPEDIDO")
	private Pedido pedido;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDPRODUTO")
	private Produto produto;
	
	
	
}

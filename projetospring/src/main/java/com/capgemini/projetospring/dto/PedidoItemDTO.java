package com.capgemini.projetospring.dto;

import java.util.Date;

public class PedidoItemDTO {
	private int id;
	private String numeroPedido;
	private Date data;
	
	public PedidoItemDTO(int id, String pedido, Date data) {
		this.setId(id);
		this.setData(data);
		this.setNumeroPedido(pedido);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumeroPedido() {
		return numeroPedido;
	}
	public void setNumeroPedido(String numeroPedido) {
		this.numeroPedido = numeroPedido;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
	
}

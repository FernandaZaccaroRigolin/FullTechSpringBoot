package com.capgemini.projetospring.dto;

import java.util.Date;

public class PedidoClienteDTO {
	
	private int id;
	private Date data;
	private String numeroPedido;
	private ClienteDTO cliente;
	
	public PedidoClienteDTO() {}
	
	public PedidoClienteDTO(int id, Date data, String pedido, ClienteDTO cliente) {
		this.setId(id);
		this.setData(data);
		this.setNumeroPedido(pedido);
		this.setCliente(cliente);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getNumeroPedido() {
		return numeroPedido;
	}
	public void setNumeroPedido(String numeroPedido) {
		this.numeroPedido = numeroPedido;
	}
	public ClienteDTO getCliente() {
		return cliente;
	}
	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}
	
	
}

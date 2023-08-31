package com.capgemini.projetospring.dto;

import java.util.Date;

public class ClientePedidosDTO {

	private int idPedido;
	private String cpf;
	private String nome;
	private String numeroPedido;
	private Date data;
	
	public ClientePedidosDTO() { }
	
	public ClientePedidosDTO(int idPedido, String cpf, String nome, String numped, Date data) {
		this.setIdPedido(idPedido);
		this.setCpf(cpf);
		this.setNome(nome);
		this.setNumeroPedido(numped);
		this.setData(data);
	}
	
	public int getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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

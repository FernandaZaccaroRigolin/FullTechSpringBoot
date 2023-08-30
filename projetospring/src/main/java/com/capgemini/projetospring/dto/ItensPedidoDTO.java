package com.capgemini.projetospring.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ItensPedidoDTO {
	
	@JsonProperty("id_item")
	private int idItem;
	
	@JsonProperty("pedido")
	private String numeroPedido;
	private double valorItem;
	private double quantidade;
	
	@JsonProperty("produto")
	private String descProduto;
	
	
	public ItensPedidoDTO(int idItem, String pedido, double valor, double quant, String descricao) {
		this.setIdItem(idItem);
		this.setNumeroPedido(pedido);
		this.setValorItem(valor);
		this.setQuantidade(quant);
		this.setDescProduto(descricao);
	}
	
	public int getIdItem() {
		return idItem;
	}
	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}
	public String getNumeroPedido() {
		return numeroPedido;
	}
	public void setNumeroPedido(String numeroPedido) {
		this.numeroPedido = numeroPedido;
	}
	public double getValorItem() {
		return valorItem;
	}
	public void setValorItem(double valorItem) {
		this.valorItem = valorItem;
	}
	public double getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}
	public String getDescProduto() {
		return descProduto;
	}
	public void setDescProduto(String descProduto) {
		this.descProduto = descProduto;
	}
	
	

}

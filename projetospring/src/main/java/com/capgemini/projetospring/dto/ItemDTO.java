package com.capgemini.projetospring.dto;

public class ItemDTO {

	private int id;
	private Double preco;
	private Double quantidade;
	private PedidoItemDTO pedido;
	private ProdutoDTO produto;
	
	public ItemDTO() {}
	
	public ItemDTO(int id, Double preco, Double quant, PedidoItemDTO pedido, ProdutoDTO produto) {
		this.setId(id);
		this.setPreco(preco);
		this.setQuantidade(quant);
		this.setPedido(pedido);
		this.setProduto(produto);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public Double getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}
	public PedidoItemDTO getPedido() {
		return pedido;
	}
	public void setPedido(PedidoItemDTO pedido) {
		this.pedido = pedido;
	}
	public ProdutoDTO getProduto() {
		return produto;
	}
	public void setProduto(ProdutoDTO produto) {
		this.produto = produto;
	}
	
	
}

package com.capgemini.projetospring.dto;

public class ProdutoDTO {
	private int id;
	private String descricao;
	private String unidade;
	private Double preco;
	
	public ProdutoDTO() { }
	
	public ProdutoDTO (int id, String descricao, String unidade, Double preco) {
		this.setId(id);
		this.setDescricao(descricao);
		this.setUnidade(unidade);
		this.setPreco(preco);
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getUnidade() {
		return unidade;
	}
	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	
}

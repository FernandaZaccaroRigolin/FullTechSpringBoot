package com.capgemini.projetospring.dto;

public class ClienteDTO {
	private String cpf;
	private String nome;
	private String telefone;
	private String email;
	
    //Construtor completo
	public ClienteDTO(String cpf, String nome, String telefone, String email) {
		this.setCpf(cpf);
		this.setNome(nome);
		this.setTelefone(telefone);
		this.setEmail(email);
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
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}

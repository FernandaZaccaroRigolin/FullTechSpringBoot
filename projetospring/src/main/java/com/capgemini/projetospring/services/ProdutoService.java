package com.capgemini.projetospring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.projetospring.models.Produto;
import com.capgemini.projetospring.repository.ProdutoRepository;

@Service
public class ProdutoService {
	@Autowired
	private ProdutoRepository produtoRepository;

	public Produto incluir(Produto produto) {
		return produtoRepository.save(produto);
	}

	public List<Produto> listar() {
		return produtoRepository.findAll();
	}
}

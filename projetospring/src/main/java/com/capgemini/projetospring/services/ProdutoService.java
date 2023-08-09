package com.capgemini.projetospring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.capgemini.projetospring.models.Produto;
import com.capgemini.projetospring.repository.ProdutoRepository;

@Service
public class ProdutoService {
	//@Autowired
	private ProdutoRepository produtoRepository;

	public ProdutoService(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}
	
	public Produto incluir(Produto produto) {
		Optional<Produto> prod = produtoRepository.findById(produto.getId());
		if(!prod.isEmpty()) {
			throw new RuntimeException("Este produto já existe");
		}
		return produtoRepository.save(produto);
	}

	public List<Produto> listar() {
		return produtoRepository.findAll();
	}
}
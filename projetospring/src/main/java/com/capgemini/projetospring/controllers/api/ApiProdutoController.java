package com.capgemini.projetospring.controllers.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.projetospring.models.Produto;
import com.capgemini.projetospring.services.ProdutoService;

@RestController
@RequestMapping("/api/produtos")
public class ApiProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping("/")
	public List<Produto> listarProdutos() {
		return produtoService.listar();
	}

	
	@PostMapping("/")
	public Produto incluirProduto(@RequestBody Produto produto) {
		return produtoService.incluir(produto);
	}
	
	
}

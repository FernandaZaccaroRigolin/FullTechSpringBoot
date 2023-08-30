package com.capgemini.projetospring.controllers.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.projetospring.dto.ProdutoDTO;
import com.capgemini.projetospring.models.Produto;
import com.capgemini.projetospring.services.ProdutoService;

@RestController
@RequestMapping("/api/produtos")
public class ApiProdutoController {
	
	//@Autowired
	private ProdutoService produtoService;
	
	public ApiProdutoController(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}
	
	@CrossOrigin
	@GetMapping("/")
	public List<ProdutoDTO> listarProdutosDTO(){
		return produtoService.listarProdutosDTO();
	}
	
	@GetMapping("/lista")
	public List<Produto> listarProdutos() {
		return produtoService.listar();
	}
	
	@CrossOrigin
	@PostMapping("/")	
	public ResponseEntity<Object> incluirProduto(@RequestBody Produto produto) {
		try {
			return new ResponseEntity<Object>(produtoService.incluir(produto), HttpStatus.CREATED);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.toString());
		}
		
	}
}

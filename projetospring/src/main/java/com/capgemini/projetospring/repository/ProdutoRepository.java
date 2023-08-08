package com.capgemini.projetospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.projetospring.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

}

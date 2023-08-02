package com.capgemini.projetospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.projetospring.models.Cliente;

public interface ClienteRepository  extends JpaRepository<Cliente, String>{

}

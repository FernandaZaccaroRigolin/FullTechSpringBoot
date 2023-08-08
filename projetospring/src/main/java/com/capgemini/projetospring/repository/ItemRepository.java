package com.capgemini.projetospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.projetospring.models.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{
	
	
}

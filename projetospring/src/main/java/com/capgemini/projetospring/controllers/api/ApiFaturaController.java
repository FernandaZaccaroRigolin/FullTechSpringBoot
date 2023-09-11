package com.capgemini.projetospring.controllers.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.projetospring.dto.FaturaDTO;
import com.capgemini.projetospring.events.KafkaClient;
import com.capgemini.projetospring.services.FaturaService;

@RestController
@RequestMapping("/api/faturas")
public class ApiFaturaController {

	private final KafkaClient kafkaClient;
	private final FaturaService faturaService;
	
	public ApiFaturaController(
			KafkaClient kafkaClient, 
			FaturaService faturaService) {
		this.kafkaClient = kafkaClient;
		this.faturaService = faturaService;
	}
	
	@PostMapping
	public ResponseEntity<?> enviarFatura(@RequestBody FaturaDTO fatura) {
		try {
			
			FaturaDTO faturaDTO = faturaService.buscarPedido(
					fatura.getIdPedido(), 
					fatura.getNumeroCartao());
					
			kafkaClient.sendMessage(faturaDTO);
			return ResponseEntity.status(HttpStatus.CREATED).body(faturaDTO);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.toString());
		}
	}
}


package com.capgemini.projetospring.events;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.capgemini.projetospring.dto.FaturaDTO;

@Service
public class KafkaClient {
	
	private final KafkaTemplate<Integer, FaturaDTO> kafkaTemplate;
	private static final String TOPIC_NAME = "custom_topic"; // se não existir, é criado
	
	public KafkaClient(KafkaTemplate<Integer, FaturaDTO> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void sendMessage(FaturaDTO fatura) {
		kafkaTemplate.send(TOPIC_NAME, fatura);
	}
}


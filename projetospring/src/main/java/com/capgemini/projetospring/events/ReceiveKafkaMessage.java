package com.capgemini.projetospring.events;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.capgemini.projetospring.dto.FaturaDTO;
import com.capgemini.projetospring.models.Fatura;
import com.capgemini.projetospring.repository.FaturaRepository;

@Service
public class ReceiveKafkaMessage {

	private static final String TOPIC_NAME = "custom_topic";
	private static final String TOPIC_RESULT = "custom_topic_result";
	
	private final KafkaTemplate<Integer, FaturaDTO> kafkaTemplate;
	private final FaturaRepository faturaRepository;
	
	public ReceiveKafkaMessage(KafkaTemplate<Integer, FaturaDTO> kafkaTemplate,FaturaRepository faturaRepository) {
		this.kafkaTemplate = kafkaTemplate;
		this.faturaRepository = faturaRepository;
	}
	
	// valor defult definido em consumer.properties
	@KafkaListener(topics = TOPIC_NAME, groupId = "test-consumer-group")
	public void listerFaturaTopic(FaturaDTO faturaDTO) {
		try {
			Fatura fatura = new Fatura(
					faturaDTO.getNumeroCartao(), 
					faturaDTO.getIdPedido(), 
					faturaDTO.getValor(), 
					faturaDTO.getStatus());
			
			faturaRepository.save(fatura);
			// enviando mensagem para uma fila de confirmação
			kafkaTemplate.send(TOPIC_RESULT, faturaDTO);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}


package com.capgemini.projetospring.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.capgemini.projetospring.dto.FaturaDTO;

@Configuration
public class KafkaConfig {

	private String bootstrapAddress = "localhost:9092";
	
	public ProducerFactory<Integer, FaturaDTO> producerFactory() {
		Map<String, Object> props = new HashMap<>();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		props.put(ProducerConfig.CLIENT_ID_CONFIG, "fatura-api");
		
		return new DefaultKafkaProducerFactory<>(props);		
	}
	
	@Bean
	public KafkaTemplate<Integer, FaturaDTO> kafkaTemplate() {
		return new KafkaTemplate<>(producerFactory());
	}
	
	public ConsumerFactory<Integer, FaturaDTO> consumerFactory() {
		JsonDeserializer<FaturaDTO> deserializer = new JsonDeserializer<>(FaturaDTO.class);	
		Map<String, Object> props = new HashMap<>();
		
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);		
				
		return new DefaultKafkaConsumerFactory<>(props, null, deserializer);		
	}
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory<Integer, FaturaDTO> kafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<Integer, FaturaDTO> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory());
		return factory;
	}
	
	
}

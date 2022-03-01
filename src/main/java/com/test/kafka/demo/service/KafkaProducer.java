package com.test.kafka.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.test.kafka.demo.IncomingMessage;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class KafkaProducer {
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	public void sendMessage(IncomingMessage message) {
		log.info("Producing Message - Key {}, Value {}, to topic {}", message.getKey(), message.getValue(), message.getTopic());
		kafkaTemplate.send(message.getTopic(),message.getKey() , message.getValue());
		
	}

}

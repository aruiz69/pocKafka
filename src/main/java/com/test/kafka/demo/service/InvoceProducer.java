package com.test.kafka.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.test.kafka.demo.generator.model.PosInvoce;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class InvoceProducer {
	@Value("${application.configs.topic.name}")
	private String TOPIC_NAME;
	@Autowired
	private KafkaTemplate<String, PosInvoce> kafkaTemplate;
	
	public void sendInvoce(PosInvoce invoce) {
		log.info("Info sent to topic {}, invoce: ", TOPIC_NAME, invoce.toString());
		kafkaTemplate.send(TOPIC_NAME, invoce.getId().toString(), invoce);	
	}

}

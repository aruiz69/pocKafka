package com.test.kafka.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.kafka.demo.IncomingMessage;
import com.test.kafka.demo.generator.Generator;
import com.test.kafka.demo.generator.GeneratorAvro;
import com.test.kafka.demo.generator.model.PosInvoce;
import com.test.kafka.demo.service.InvoceProducerAvro;
import com.test.kafka.demo.service.KafkaProducer;

@RestController
public class Controller {
	
	@Autowired
	KafkaProducer kafkaProducer;
	@Autowired
	Generator generator;
	
	@Value("${application.configs.invoce.count}")
	private int INVOCE_COUNT;
	
	@Autowired
	InvoceProducerAvro invoceProducer;
	@Autowired
	GeneratorAvro generatorAvro;
	

	
	@PostMapping("/post")
	public String sendMessageToKafka(@RequestBody IncomingMessage message ) {
		kafkaProducer.sendMessage(message);
		return String.format("Success - message  for key %s is sent to Kafka Topic %s", message.getKey(), message.getTopic());
	}
	
	
	@GetMapping("/getInvoce")
	public PosInvoce getPosInvoce() {
		return generator.createPosInvoce();
	}
	
	@GetMapping("/produceAvro")
	public String prodAvro() throws InterruptedException {
		for(int i= 0; i < INVOCE_COUNT; i++) {
			invoceProducer.sendInvoce(generatorAvro.createPosInvoce());
			Thread.sleep(1000);
		}
		return "OK";
	}
	
}

package com.test.kafka.demo.generator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.kafka.demo.generator.model.avro.DeliveryAddress;
import com.test.kafka.demo.generator.model.avro.LineItem;
import com.test.kafka.demo.generator.model.avro.PosInvoce;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class GeneratorAvro {
	
	final Random random;
	final DeliveryAddress[] addreess;
	final LineItem[] lineItem;
	final String[] name = {"Celso", "Pedro", "Marcelo", "Fabian", "Alvaro" };
	
	public GeneratorAvro() {
		String dataFile = "src/main/resources/jsonData/DeliveryAddressData.json";
		String dataItemFile = "src/main/resources/jsonData/LineItem.json";
		ObjectMapper mapper = new ObjectMapper(); 
		random = new Random();
		try {
			addreess = mapper.readValue(new File(dataFile), DeliveryAddress[].class);
			lineItem  = mapper.readValue(new File(dataItemFile), LineItem[].class);
		} catch (IOException e) {
			log.error("Error", e);
			throw new RuntimeException(e);
		}
		
	}
	
	
	public PosInvoce createPosInvoce() {
		
		List<LineItem> items = new ArrayList<>();
		items.add(lineItem[getIndexItem()]);
		items.add(lineItem[getIndexItem()]);
		items.add(lineItem[getIndexItem()]);
		PosInvoce invoce = new PosInvoce();
		invoce.setId(UUID.randomUUID().toString());
		invoce.setDelivery(addreess[getIndexAddress()]);
		invoce.setName(name[getIndexName()]);
		invoce.setItems(items);
		return invoce;
		
	}
	
	
	private int getIndexAddress() {
		return random.nextInt(5);
	}
	
	private int getIndexItem() {
		return random.nextInt(7);
	}
	
	private int getIndexName() {
		return random.nextInt(5);
	}
}

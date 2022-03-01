package com.test.kafka.demo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class IncomingMessage {
	String key;
	String topic;
	String value;
}

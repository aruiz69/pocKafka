package com.test.kafka.demo.generator.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PosInvoce {
	private String id;
	private String name;
	private DeliveryAddress delivery;
	private List<LineItem> items;

}

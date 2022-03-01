package com.test.kafka.demo.generator.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LineItem {
	private String itemCode;
	private String itemDescription;
	private Double itemPrice;
	private Integer itemQuantity;
	private Double totalValue;;

}

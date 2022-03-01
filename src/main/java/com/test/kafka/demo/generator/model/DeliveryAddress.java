package com.test.kafka.demo.generator.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeliveryAddress {
	@JsonProperty("addressline")
	private String addressline;
	@JsonProperty("city")
	private String city;
	@JsonProperty("state")
	private String state;
	@JsonProperty("pinCode")
	private String pinCode;
	@JsonProperty("contactNumber")
	private String contactNumber;
	
}

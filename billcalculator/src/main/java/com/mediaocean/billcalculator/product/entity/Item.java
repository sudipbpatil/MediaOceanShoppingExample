package com.mediaocean.billcalculator.product.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class Item {
	
	private int productId;
	private int quantity;
	private String productName;
	private String description;
	private double priceSingleUnit;
	private double priceTotal;
	private double tax;
	private double taxPercent;
	private String catagory;
	
}






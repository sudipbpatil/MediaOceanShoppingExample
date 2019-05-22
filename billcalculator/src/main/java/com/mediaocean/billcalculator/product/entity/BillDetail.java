package com.mediaocean.billcalculator.product.entity;

import java.util.List;

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
public class BillDetail {
	
    private List<Item> items;
	private double totalPrice;
	private double totalTax;
	private double finalAmountToPay;
	

}

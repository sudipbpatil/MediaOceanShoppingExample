package com.mediaocean.billcalculator.service.exception;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProductNotFoundException extends Exception {
	
	private static final long serialVersionUID = 8211224642183278072L;
	private static String message;
	
	public ProductNotFoundException(){
		super(message);
	}

}

package com.mediaocean.billcalculator.product.Interface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mediaocean.billcalculator.product.entity.BillDetail;
import com.mediaocean.billcalculator.product.entity.ShoppingCart;
import com.mediaocean.billcalculator.service.ShoppingService;
import com.mediaocean.billcalculator.service.exception.ProductNotFoundException;

import io.swagger.annotations.ApiParam;

@RestController
public class ShoppingController {

	@Autowired
	ShoppingService shoppingService;

	@PostMapping("/bill")
	public BillDetail getBill(@RequestBody ShoppingCart shoppingCart) throws ProductNotFoundException {
		return shoppingService.calculateBill(shoppingCart);

	}

}

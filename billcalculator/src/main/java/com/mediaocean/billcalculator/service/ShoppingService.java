package com.mediaocean.billcalculator.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mediaocean.billcalculator.product.dao.ProductRepository;
import com.mediaocean.billcalculator.product.entity.BillDetail;
import com.mediaocean.billcalculator.product.entity.Item;
import com.mediaocean.billcalculator.product.entity.Product;
import com.mediaocean.billcalculator.product.entity.ShoppingCart;
import com.mediaocean.billcalculator.service.exception.ProductNotFoundException;

@Service
public class ShoppingService {

	@Autowired
	ProductRepository productRepository;


	public BillDetail calculateBill(ShoppingCart shoppingCart) throws ProductNotFoundException {
		double totalPrice = 0, tax = 0;
		BillDetail billDetail = new BillDetail();
		List<Item> items = new ArrayList<Item>();
		for (Item item_input : shoppingCart.getItems()) {

			Item item = getItemDetailsByProductId(item_input.getProductId());
			item.setQuantity(item_input.getQuantity());
			item.setPriceTotal(item.getPriceSingleUnit() * item.getQuantity());
			item.setTax(item.getPriceTotal() * item.getTaxPercent());
			totalPrice = totalPrice + item.getPriceTotal();
			tax = tax + item.getTax();
			items.add(item);
		}

		billDetail.setItems(items);
		billDetail.setTotalPrice(totalPrice);
		billDetail.setTotalTax(tax);
		billDetail.setFinalAmountToPay(totalPrice + tax);
		return billDetail;
	}

	public List<Item> getAllProductDetails() throws ProductNotFoundException {
		List<Product> products = productRepository.findAll();
		List<Item> items = new ArrayList<Item>();
		for (Product product : products) {
			items.add(getItemDetailsByProductId(product.getProductId()));
		}

		return items;
	}

	private Item getItemDetailsByProductId(int productId) throws ProductNotFoundException {

		Optional<Product> productOptrional = productRepository.findById(productId);
		
		
		Product product = productOptrional.orElseThrow(()->new ProductNotFoundException());
		
		Item item = new Item();
		item.setProductId(product.getProductId());
		item.setProductName(product.getName());
		item.setDescription(product.getDescription());
		item.setPriceSingleUnit(product.getAttribute().getPrice());
		item.setCatagory(product.getAttribute().getProductTax().getCatagoryName());
		item.setTaxPercent(product.getAttribute().getProductTax().getTax());
		return item;
	}

}

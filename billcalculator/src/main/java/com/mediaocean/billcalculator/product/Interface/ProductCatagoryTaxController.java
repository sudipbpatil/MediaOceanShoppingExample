package com.mediaocean.billcalculator.product.Interface;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mediaocean.billcalculator.product.dao.ProductTaxRepository;
import com.mediaocean.billcalculator.product.entity.Product;
import com.mediaocean.billcalculator.product.entity.ProductTax;

@RestController
public class ProductCatagoryTaxController {

	@Autowired
	ProductTaxRepository productTaxRepository;
	
	@GetMapping("/product/catagory")
	@Cacheable("ProductTax")
	public List<ProductTax> retriveAllProducts(){
		List<ProductTax> productTaxList = productTaxRepository.findAll();
		return productTaxList;
	}
	
	@Cacheable("ProductTax")
	@GetMapping("/product/catagory/{catagotyId}")
	public ProductTax retriveProductById(@PathVariable Integer catagotyId){
		 Optional<ProductTax> productTax = productTaxRepository.findById(catagotyId);
		 return productTax.get();
	}
	
	@DeleteMapping("/product/catagory/{productId}")
	public void deleteProduct(@PathVariable Integer catagotyId) {
		productTaxRepository.deleteById(catagotyId);
	}
	
	@PostMapping("/product/catagory")
	public ProductTax addProduct(@RequestBody ProductTax productTax) {
		ProductTax productTaxResult = productTaxRepository.save(productTax);
		return productTaxResult; 
	}
	
	
	
}

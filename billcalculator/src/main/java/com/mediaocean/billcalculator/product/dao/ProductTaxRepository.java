package com.mediaocean.billcalculator.product.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mediaocean.billcalculator.product.entity.ProductAttribute;
import com.mediaocean.billcalculator.product.entity.ProductTax;

@Repository
public interface ProductTaxRepository extends JpaRepository<ProductTax, Integer>{
	
}

package com.mediaocean.billcalculator.product.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ApiModel(description="all Products attributes including price")
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @AllArgsConstructor
@EqualsAndHashCode
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ProductAttribute {

	@Id @JsonBackReference
	private int productId;
	private double price;
	
	//private int catagoryId;
	
	@OneToOne(cascade = CascadeType.ALL, 
              fetch = FetchType.EAGER)
	@JoinColumn(name="catagoryId")
	@JsonManagedReference
	private ProductTax productTax;
}

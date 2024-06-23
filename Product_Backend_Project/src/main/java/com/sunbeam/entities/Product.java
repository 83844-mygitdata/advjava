package com.sunbeam.entities;
import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Table(name = "products")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Product extends BaseEntity{
	
	private double price;
	private int availableQuantity;
	@Column(unique = true)
	private String product_name;
	

	
	
	
//	
//	@ManyToOne
//	@JoinColumn(name="category_id",nullable = false)
//	private Category productCategory;
//	
//	
	
	public Product( String product_name, double price, int availableQuantity) {
		super();
		
		this.product_name = product_name;
		this.price = price;
		this.availableQuantity = availableQuantity;
	}









	
	
	

	
}

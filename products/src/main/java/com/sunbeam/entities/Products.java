package com.sunbeam.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "products")

public class Products {
//Refer - products table - id , category (BAKERY|SHOES|CLOTHES|STATIONAY) ,product name(unique)  , price , available quantity
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Enumerated(EnumType.STRING)
	@Column(name = "Category", length = 25)
	private Category category;
	@Column(name = "Name", length = 25)
	private String name;
	@Column(name = "Price")
	private double price;
	@Column(name = "Available_Quantity")
	private int availableQuantity;
	
	
	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Products(Category category, String name, double price, int availableQuantity) {
		super();
		this.category = category;
		this.name = name;
		this.price = price;
		this.availableQuantity = availableQuantity;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getAvailableQuantity() {
		return availableQuantity;
	}
	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}
	

	@Override
	public String toString() {
		return "products [id=" + id + ", category=" + category + ", name=" + name + ", price=" + price
				+ ", availableQuantity=" + availableQuantity + "]";
	}
	
	
	
}

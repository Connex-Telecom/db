package com.connex.interviewdb.controller.model;

import jakarta.persistence.*;

@Entity
@Table(name = "items")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "price")
	private double price;

	@Column(name = "stock")
	private int stock;

	public Item() {

	}

	public Item(String name, String description, double price, int stock) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.stock = stock;
	}

	public long getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + ", stock="
				+ stock + "]";
	}

}

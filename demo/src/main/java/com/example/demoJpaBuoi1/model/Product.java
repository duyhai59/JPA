package com.example.demoJpaBuoi1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "jpaproduct")
@Entity
public class Product {
	@Id
	private int Id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "price")
	private double price;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
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
	
}

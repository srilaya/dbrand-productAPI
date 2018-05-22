package com.dbrand.store.model;

import java.util.concurrent.atomic.AtomicInteger;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="Product")
public class Product {

	//private static final AtomicInteger count = new AtomicInteger(0);

	@Id
	private long id; // Auto-generating ID as this is the primary key
	private String name;
	private String type;
	private String description;
	private static final int quantity = 10;

	public int getQuantity() {
		return quantity;
	}

	public Product() {
	}

	public Product(long id, String name, String type, String description) {
		
		this.id = id;
		this.name = name;
		this.type = type;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}

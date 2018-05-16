package com.dbrand.store.products;

import java.util.concurrent.atomic.AtomicInteger;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {

	private static final AtomicInteger count = new AtomicInteger(0);

	@Id
	private long id; // Auto-generating ID as this is the primary key
	private String name;
	private String type;
	private String description;
	private int quantity;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product() {
		// id = Long.valueOf(count.incrementAndGet());
		id = count.incrementAndGet();
	}


	public Product(String name, String type, String description, int quantity) {
		
		this.name = name;
		this.type = type;
		this.description = description;
		this.quantity = quantity;
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

}

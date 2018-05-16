package com.dbrand.store.products;

import java.util.concurrent.atomic.AtomicInteger;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {

	private static final AtomicInteger count = new AtomicInteger(0); 
	
	@Id
	private Long id;
	private String name;
	private String type;
	private String description;
	
	public Product() {	
		id = Long.valueOf(count.incrementAndGet());
	}
	
	public Product(String name, String type, String description) {
		
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
	
}

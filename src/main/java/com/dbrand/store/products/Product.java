package com.dbrand.store.products;

import java.util.concurrent.atomic.AtomicInteger;

public class Product {

	private static final AtomicInteger count = new AtomicInteger(0); 
	private long id;
	private String name;
	private String type;
	private String description;
	
	public Product() {	
	}
	
	public Product(String name, String type, String description) {
		
		this.name = name;
		this.type = type;
		this.description = description;
		id = count.incrementAndGet();
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
	public long getId() {
		return id;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}

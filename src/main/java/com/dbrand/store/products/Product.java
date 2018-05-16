package com.dbrand.store.products;

public class Product {

	String name;
	String type;
	long id;
	String description;
	
	public Product() {	
		
	}
	
	public Product(String name, String type, long id, String description) {
		
		this.name = name;
		this.type = type;
		this.id = id;
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
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}

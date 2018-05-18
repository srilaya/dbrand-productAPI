package com.dbrand.store.model;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.persistence.Entity;
import javax.persistence.Id;

//@Entity
public class Order {

	private static final AtomicInteger count = new AtomicInteger(0);

	//@Id
	private long id; // Auto-generating ID as this is the primary key
	private Product product;
	private int quantity;

	public Order() {
	}

	public Order(Product product, int quantity) {

		this.product = product;
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}

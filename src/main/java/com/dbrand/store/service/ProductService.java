package com.dbrand.store.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbrand.store.DAO.ProductRepository;

import com.dbrand.store.exception.DataNotFoundException;
import com.dbrand.store.exception.DataNotFoundExceptionHandler;
import com.dbrand.store.model.Product;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	// get all products in the repo
	public List<Product> getAllProducts() {

		List<Product> productList = new ArrayList<>();
		productRepository.findAll().forEach(productList::add);
		return productList;
	}

	// returns just one product by name;
	// Assuming it will only return first product it finds with this name
	public Product getProductByName(String name) {

		List<Product> productList = new ArrayList<>();
		
	try{
		productRepository.findAll().forEach(p -> {
			if (p.getName().equals(name)) {
				productList.add(p);
			}
		});
	}catch(DataNotFoundException d){
		DataNotFoundExceptionHandler dh = new DataNotFoundExceptionHandler();
		dh.exceptionOccurred(d);
	}
		
		
		return productList.stream().findFirst().get();
	}

	// get product by type
	public List<Product> getProductByType(String type) {

		List<Product> productList = new ArrayList<>();
		productRepository.findAll().forEach(p -> {
			if (p.getType().equals(type)) {
				productList.add(p);
			}
		});
		
		if(productList.size()==0){
			throw new DataNotFoundException("Sorry. Product type --> "+ type +": Not found in our catalog !");
		}
		
		return productList;

	}

	// adds new product
	public void addProduct(Product product) {

		productRepository.save(product);
	}

	// deletes product
	public void deleteProduct(String name) {

		productRepository.findAll().forEach(p -> {
			if (p.getName().equals(name)) {
				productRepository.deleteById(p.getId());
			}
		});
	}

}

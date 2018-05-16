package com.dbrand.store.products;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		productRepository.findAll().forEach(p -> {
			if (p.getName().equals(name)) {
				productList.add(p);
			}
		});
		
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

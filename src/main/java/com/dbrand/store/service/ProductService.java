package com.dbrand.store.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbrand.store.DAO.ProductRepository;
import com.dbrand.store.exception.ProductDoesNotExistException;
import com.dbrand.store.exception.ProductExistsException;
import com.dbrand.store.exception.ProductServiceException;
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

		try {
			productRepository.findAll().forEach(p -> {
				if (p.getName().equals(name)) {
					productList.add(p);
				}
			});
		} catch (Exception e) {
				e.printStackTrace();
		}

		return productList.stream().findFirst().get();
	}

	// get product by type
	public List<Product> getProductByType(String type) throws ProductServiceException {

		List<Product> productList = new ArrayList<>();
		if (productList.size() == 0) {
			throw new ProductServiceException(404, "No Such type exists. Please review your request. ");
		}

		productRepository.findAll().forEach(p -> {
			if (p.getType().equals(type)) {
				productList.add(p);
			}
		});

		return productList;
	}

	// searches for a product by its ID 
	public Optional<Product> getProductById(long id) throws ProductServiceException {

		if (!productRepository.existsById(id)) {
			throw new ProductServiceException(404, "This ID does not exist");
		}

		return productRepository.findById(id);
	}

	// adds new product
	public void addProduct(Product product) throws ProductExistsException {
		
		Optional<Product> p = productRepository.findById(product.getId()); 
		if(p.isPresent()){
			throw new ProductExistsException(500, "This Product already exists !");
		}
			
		productRepository.save(product);			
	}

	// deletes a product from the repo
	public void deleteProduct(long id) throws ProductDoesNotExistException {

		Optional<Product> p = productRepository.findById(id);
		if (p.isPresent()) {
			productRepository.deleteById(id);
		} else {
			throw new ProductDoesNotExistException();
		}
	}

}

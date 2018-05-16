package com.dbrand.store.products;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class ProductService {

	List<Product> products = new ArrayList<>(Arrays.asList(
			new Product("Phone","Electronic",1,"Used for making calls"),
			new Product("Nutrabullet","Kitchen Appliance",2,"Helps in kitchen work"),
			new Product("Laptop","Electronic",3,"Used for browsing")
			));
	
	public List<Product> getAllProducts(){
		return products;
	}
	
//	public List<Product> getProduct(String param){
//		
//		if(products.contains( products.stream().filter( p -> p.getType().equals(param)))){
//			getProductByType(param);
//		}else{
//			getProductByName(param);
//		}
//	}
	
	public List<Product> getProductByType(String type){
		
		return products.stream()
				 	   .filter( p-> p.getType().equals(type))
				 	   .collect(Collectors.toList());
	}
	
	public Product getProductByName(String name) {
		return products.stream()
					   .filter(p -> p.getName().equals(name))
					   .findFirst().get();	
	}
	
	
	public void addProduct(Product product){
	
		products.add(product);
	}

	
	public void deleteProduct(String name) {
		 	
		products.removeIf( p-> p.getName().equals(name) );
		
	}

	
	
	
}

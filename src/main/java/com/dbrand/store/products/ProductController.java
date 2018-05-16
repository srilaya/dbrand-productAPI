package com.dbrand.store.products;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	//* Retrieve a list of products
	@RequestMapping("/products")
	public List<Product> getProducts(){
		return productService.getAllProducts();
	}
	
	//* Return list of products by type
	@RequestMapping(method= RequestMethod.GET, value = "/products/{type}")
	public List<Product> getProductByType(@PathVariable String type){	
		
		return productService.getProductByType(type);
	}
	
	@RequestMapping(method= RequestMethod.POST, value = "/products")
	public void addProduct(@RequestBody Product product){	
		
		productService.addProduct(product);
	}		
		
	//* Delete an item
	@RequestMapping(method= RequestMethod.DELETE, value = "/products/{name}")
	public void deleteProduct(@PathVariable String name){	
		
		productService.deleteProduct(name);
	}
	
	
}

package com.dbrand.store.orders;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dbrand.store.products.Product;

@RestController
public class OrderController {
	

	@Autowired
	private OrderService orderService;
	
	//* Add products onto cart
	@RequestMapping(method= RequestMethod.POST, value = "/orders")
	public void addProducts(Product product){
		//return orderService.addProduct(product);
	}
	

}

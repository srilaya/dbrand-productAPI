package com.dbrand.store.orders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dbrand.store.products.Product;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	public void addProduct(Product product, int quantity){
		orderRepository.save(product);
	}
	
	
		
	

}

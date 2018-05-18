package com.dbrand.store.DAO;

import org.springframework.data.repository.CrudRepository;

import com.dbrand.store.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{
	
	 

}

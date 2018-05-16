package com.dbrand.store.orders;

import org.springframework.data.repository.CrudRepository;

import com.dbrand.store.products.Product;

public interface OrderRepository extends CrudRepository<Product,Integer> {

}

package com.dbrand.store.products;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class ProductControllerTest {

	@Mock
	private ProductService productService;
	private ProductController productController;
	
	@Before
	public void setup(){
		productController = new ProductController();
	}
	
	@Test
	public void testGetProducts() {
		
	}

	@Test
	public void testGetProductByType() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddProduct() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteProduct() {
		fail("Not yet implemented");
	}

}

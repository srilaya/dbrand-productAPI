package com.dbrand.store.controller;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import com.dbrand.store.model.Product;
import com.dbrand.store.service.ProductService;

@RunWith(MockitoJUnitRunner.class)
public class ProductControllerTest {

	public static List<Product> productList;
	public static Optional<Product> testProductOptional;
	public static Product testProduct;

	@Mock
	private ProductService productService;

	@InjectMocks
	private ProductController productController;

	@Before
	public void initMockito() {
		MockitoAnnotations.initMocks(this);
	}

	@BeforeClass
	public static void initProduct() {

		productList = new ArrayList<>();
		productList.add(new Product(1, "kettle", "electronics", "color: white "));
		productList.add(new Product(2, "ipad", "electronics", "color: black, 7' screen"));
		productList.add(new Product(3, "macbook", "electronics", "color: silver, 15' screen"));
		productList.add(new Product(4, "toy train", "toys", "color:red"));
		productList.add(new Product(5, "Avengers", "movies", "DVD; Blue ray"));

		testProduct = new Product(1, "kettle", "electronics", "color: white ");
		testProductOptional = Optional.of(testProduct);
	}

	@Test
	public void getProductsTest() {

		when(productService.getAllProducts()).thenReturn(productList);

		List<Product> called_productList = productController.getProducts();

		verify(productService).getAllProducts();
		assertEquals(productList.get(0).getName(), called_productList.get(0).getName());
	}

	@Test
	public void getProductByIdTest() throws Exception {

		when(productService.getProductById(1)).thenReturn(testProductOptional);

		Optional<Product> testProductActual = productController.getProductById(1);
		verify(productService).getProductById(1);
		assertTrue(testProductActual.isPresent());
		assertEquals(testProductOptional.get().getName(), testProductActual.get().getName());
	}

	@Test
	public void addProductTest() throws Exception {

		productController.addProduct(testProduct);
		verify(productService).addProduct(testProduct);
	}

	@Test
	public void deleteProduct() throws Exception {

		productController.deleteProduct(testProduct.getId());
		verify(productService).deleteProduct(testProduct.getId());
	}

}

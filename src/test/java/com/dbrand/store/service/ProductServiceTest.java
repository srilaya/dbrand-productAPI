package com.dbrand.store.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.hamcrest.Matchers;

import static org.mockito.Mockito.*;  

import com.dbrand.store.DAO.ProductRepository;
import com.dbrand.store.exception.ProductDoesNotExistException;
import com.dbrand.store.exception.ProductExistsException;
import com.dbrand.store.exception.ProductServiceException;
import com.dbrand.store.model.Product;

import ch.qos.logback.core.filter.Filter;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

	public static List<Product> testProductList;
	public static Optional<Product> testProductOptional;
	public static Product testProduct;

    
	@Mock
	private ProductRepository productRepository;

	@InjectMocks
	private ProductService productService;

	
	@Before
	public void initMockito() {
		MockitoAnnotations.initMocks(this);
	}

	@BeforeClass
	public static void initProduct() {

		testProductList = new ArrayList<>();
		testProductList.add(new Product(1L, "kettle", "electronics", "color: white "));
		testProductList.add(new Product(2L, "ipad", "electronics", "color: black, 7' screen"));
		testProductList.add(new Product(3L, "macbook", "electronics", "color: silver, 15' screen"));
		testProductList.add(new Product(4L, "toy train", "toys", "color:red"));
		testProductList.add(new Product(5L, "Avengers", "movies", "DVD; Blue ray"));

		testProduct = new Product(1L, "kettle", "electronics", "color: white ");
		testProductOptional = Optional.of(testProduct);
	}

	@Test
	public void getAllProductsTest() {
		
		when(productRepository.findAll()).thenReturn(testProductList);
		List<Product> actualProductListActual = productService.getAllProducts();
		verify(productRepository).findAll();
		
		assertEquals(testProductList,actualProductListActual);
	}

	/*  These test cases are expected to pass
	 *  Happy Paths	 */ 
	
	@Test
	public void getProductByNameTest() throws ProductServiceException {

		when(productRepository.findById(anyLong())).thenReturn(testProductOptional);
		Optional<Product> testProductActual = productService.getProductById(1L);
		verify(productRepository).findById(anyLong());
		assertTrue(testProductActual.isPresent());
		assertEquals(testProduct, testProductActual);
	}

	
	@Test
	public void getProductByTypeTest() throws ProductServiceException{
		
		when(productRepository.findAll()).thenReturn(testProductList);
		List<Product> testProductListFiltered = testProductList.stream()
									  			.filter(p -> p.getType().equals(testProduct.getType()))
									  			.collect(Collectors.toList());
									  					 
		List<Product> testProductActualList = productService.getProductByType(testProduct.getType());
		verify(productRepository).findAll();
		assertEquals(testProductListFiltered , testProductActualList);
	}
	
	@Test
	public void getProductByIdTest() throws ProductServiceException, ProductExistsException{

		when(productRepository.findById(any())).thenReturn(testProductOptional);
		productService.addProduct(testProduct);
		Optional<Product> testProductActual = productService.getProductById(1L);
		verify(productRepository).findById(anyLong());
		assertTrue(testProductActual.isPresent());
		assertEquals(testProductActual , testProductActual);		
	}

	@Test
	public void addProductTest() throws ProductExistsException{
		
		productService.addProduct(testProduct);
		verify(productRepository).save(any());
	}

	@Test
	public void deleteProductTest() throws ProductDoesNotExistException, ProductExistsException {
		
		productService.addProduct(testProduct);
		productService.deleteProduct(testProduct.getId());
		verify(productRepository).delete(testProduct);
	}
	
	// ** These test cases expected to Fail 
	
	@Test(expected = ProductServiceException.class)
	public void getProductByNameTestFailed() throws ProductServiceException {
		 
		productService.getProductById(12L);
	}
	
	@Test(expected = ProductServiceException.class)
	public void getProductByTypeFailedTest() throws ProductServiceException{
		
		productService.getProductByType("products"); // no such type exists
	}
	
	@Test(expected = ProductServiceException.class)
	public void getProductByIdFailed() throws ProductServiceException{

		productService.getProductById(12L); // 12L was not added to the repo 
	}

	@Test(expected = ProductExistsException.class)
	public void addProductFailed() throws ProductExistsException{
		
		productService.addProduct(testProduct);
		productService.addProduct(testProduct); // this already exists in the repository
	}

	@Test(expected = ProductDoesNotExistException.class)
	public void deleteProductFailed() throws ProductDoesNotExistException {
		
		productService.deleteProduct(2L);
	}
}

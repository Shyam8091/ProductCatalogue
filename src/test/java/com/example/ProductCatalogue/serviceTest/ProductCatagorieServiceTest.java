package com.example.ProductCatalogue.serviceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.productCatalogue.dao.ProductCatagorieDao;
import com.example.productCatalogue.entity.ProductCatagorie;
import com.example.productCatalogue.exception.ResourceNotFoundException;
import com.example.productCatalogue.service.ProductCatagorieService;

@SpringBootTest
public class ProductCatagorieServiceTest {

	@Autowired
	private ProductCatagorieService productCatagorieService;

	@MockBean
	private ProductCatagorieDao productCatagorieDao;

	@BeforeEach
	void setUp() {
		ProductCatagorie productCatagorieObject = new ProductCatagorie(1L, "TEST");
		Mockito.when(productCatagorieDao.findById(1L)).thenReturn(Optional.of(productCatagorieObject));
		Mockito.when(productCatagorieDao.findByProductCatagorieNameIgnoreCase("TEST")).thenReturn(productCatagorieObject);

	}

	@Test
	@DisplayName("Get Data based on Valid productCatagorie Id")
	public void findByIdTest() {
		Long id = 1L;
		assertEquals(id, productCatagorieService.findProductCatagorieByid(1L).getId());
	}
	
	@Test
	@DisplayName("Get Exception when Id is not found")
	public void getResourseNotFoundexceptionTest() {
		Long id = 10L;
		assertThrows(ResourceNotFoundException.class,()->{productCatagorieService.findProductCatagorieByid(id);});
	}
	
	@Test
	@DisplayName("Get Data based on Valid Product Catagorie Name IgnoreCase")
	public void findByProductCatagorieNameIgnoreCaseTest() {
		String productCatagorieName="TEST";
		assertTrue(productCatagorieName.equalsIgnoreCase(productCatagorieService.fetchProductCatagorieByName("TEST").getProductCatagorieName()));
		
	}

}

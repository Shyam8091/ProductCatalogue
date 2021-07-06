package com.example.ProductCatalogue;

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
class ProductCatalogueApplicationTests {
//
//	private static ProductCatagorieDao productCatagorieDao;
//	
//	@Autowired
//	private ProductCatagorieService productCatagorieService;
//	
//	@BeforeAll
//	public static void setUp() {
//		productCatagorieDao=Mockito.mock(ProductCatagorieDao.class);
//	}
//	@Test
//	public void findByProductCatagorieNameIgnoreCaseTest() {
//		ProductCatagorie productCatagorie=new ProductCatagorie(1l,"TEST");
//		Mockito.when(productCatagorieDao.findByProductCatagorieNameIgnoreCase("TEST")).thenReturn(productCatagorie);
//		assertEquals("TEST",productCatagorie.getProductCatagorieName());
//	}
//
//	@Test
//	public void findByIdTest() {
//		ProductCatagorie productCatagorieObject=new ProductCatagorie(1l,"TEST");
//		Mockito.when(productCatagorieDao.findById(1L)).thenReturn(Optional.of(productCatagorieObject));
//		
//		assertEquals(1,productCatagorieService.findProductCatagorieByid(1l));
//	}
//	

	
}

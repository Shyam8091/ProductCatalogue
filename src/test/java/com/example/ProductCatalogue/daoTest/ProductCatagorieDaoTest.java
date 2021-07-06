package com.example.ProductCatalogue.daoTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.example.productCatalogue.dao.ProductCatagorieDao;
import com.example.productCatalogue.entity.ProductCatagorie;
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class ProductCatagorieDaoTest {

	@Autowired
	private ProductCatagorieDao productCatagorieDao;
	@Autowired
	private TestEntityManager testEntityManager;
	
	@BeforeEach
	void setUp() {
		ProductCatagorie productCatagorie=new ProductCatagorie(1L, "product1","product1 description");
		testEntityManager.persistAndFlush(productCatagorie);
//		testEntityManager.persist(productCatagorie);
		
	}
	
	@Test
	void findByIdTest() {
		ProductCatagorie productCatagorie=productCatagorieDao.findById(1L).get();
		assertEquals(productCatagorie.getProductCatagorieName(), "product1");
	}
}

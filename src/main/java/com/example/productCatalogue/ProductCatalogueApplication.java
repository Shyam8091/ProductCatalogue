package com.example.productCatalogue;

import java.util.stream.IntStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.productCatalogue.dao.ProductCatagorieDao;
import com.example.productCatalogue.entity.ProductCatagorie;
import com.example.productCatalogue.service.ProductCatagorieService;
import com.example.productCatalogue.service.impl.ProductCatagorieServiceImpl;

@SpringBootApplication
public class ProductCatalogueApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductCatalogueApplication.class, args);
	}
//	@Bean
//	CommandLineRunner runner(ProductCatagorieDao service) {
//		return null;

		
//		  return arg-> IntStream.rangeClosed(1, 5).forEach(i-> { ProductCatagorie
//		  productCatagorie=new ProductCatagorie();
//		  productCatagorie.setProductCatagorieName("p"+i);
//		  productCatagorie.setProductCatagorieDescription("This is "+i+" product catagorie details");
//		  service.save(productCatagorie); } );
		 
//	}

}

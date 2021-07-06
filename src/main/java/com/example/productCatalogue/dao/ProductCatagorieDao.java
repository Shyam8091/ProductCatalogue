package com.example.productCatalogue.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.productCatalogue.entity.ProductCatagorie;
@Repository
public interface ProductCatagorieDao extends JpaRepository<ProductCatagorie, Long>{

	ProductCatagorie findByProductCatagorieNameIgnoreCase(String name);
	
}

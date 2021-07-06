package com.example.productCatalogue.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.productCatalogue.entity.Product;
@Repository
public interface ProductDao extends JpaRepository<Product, Long> {

	

	Page<Product> findByProductCatagorieId(long id,Pageable page);

	



}

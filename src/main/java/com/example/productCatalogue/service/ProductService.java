package com.example.productCatalogue.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.productCatalogue.entity.Product;

public interface ProductService {

	Page<Product> getAllProductByCatagorie(long id,Pageable page);

}

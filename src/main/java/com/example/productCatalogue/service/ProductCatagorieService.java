package com.example.productCatalogue.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.productCatalogue.dto.ProductCatagorieDto;
import com.example.productCatalogue.entity.ProductCatagorie;


public interface ProductCatagorieService {
public ProductCatagorie addNewProductCatagorie(ProductCatagorieDto productCatagorieDto);

public Page<ProductCatagorie> getAllProductCatagories(Pageable page);

public ProductCatagorie findProductCatagorieByid(Long id);

public ProductCatagorie updateProductCatagorie(Long id,ProductCatagorieDto productCatagorieDto);

public ProductCatagorie fetchProductCatagorieByName(String name);
}

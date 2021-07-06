package com.example.productCatalogue.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.productCatalogue.dao.ProductDao;
import com.example.productCatalogue.entity.Product;
import com.example.productCatalogue.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;
	@Override
	public Page<Product> getAllProductByCatagorie(long id,Pageable page) {
		
		return productDao.findByProductCatagorieId(id,page);
	}

}

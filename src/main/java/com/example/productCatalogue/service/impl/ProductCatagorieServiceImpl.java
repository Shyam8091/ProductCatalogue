package com.example.productCatalogue.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.productCatalogue.dao.ProductCatagorieDao;
import com.example.productCatalogue.dto.ProductCatagorieDto;
import com.example.productCatalogue.entity.ProductCatagorie;
import com.example.productCatalogue.exception.ResourceNotFoundException;
import com.example.productCatalogue.service.ProductCatagorieService;

@Service
public class ProductCatagorieServiceImpl implements ProductCatagorieService {

	@Autowired
	private ProductCatagorieDao productCatagorieDao;

	@Override
	public ProductCatagorie addNewProductCatagorie(ProductCatagorieDto productCatagorieDto) {
		ProductCatagorie productCatagorie = new ProductCatagorie();
		productCatagorie.setProductCatagorieName(productCatagorieDto.getProductCatagorieName());
		productCatagorie.setProductCatagorieDescription(productCatagorieDto.getProductCatagorieDescription());

		return productCatagorieDao.save(productCatagorie);
	}

	@Override
	public Page<ProductCatagorie> getAllProductCatagories(Pageable page) {
		
		return productCatagorieDao.findAll(page);
	}

	@Override
	public ProductCatagorie findProductCatagorieByid(Long id) {
		
		return productCatagorieDao.findById(id).orElseThrow(()->new ResourceNotFoundException("ProductCatagorie is not found with id: "+id));
	}

	@Override
	public ProductCatagorie updateProductCatagorie(Long id,ProductCatagorieDto productCatagorieDto) {
		Optional<ProductCatagorie> productCatagorie=productCatagorieDao.findById(id);
		
		if(productCatagorie.isPresent()) {
			ProductCatagorie updateCatagorie= new ProductCatagorie(); 
			updateCatagorie.setId(id);
			updateCatagorie.setProductCatagorieName(productCatagorieDto.getProductCatagorieName());
			updateCatagorie.setProductCatagorieDescription(productCatagorieDto.getProductCatagorieDescription());
			updateCatagorie.setStartDate(productCatagorie.get().getStartDate());
			return productCatagorieDao.save(updateCatagorie);
		}
		else {
			throw new ResourceNotFoundException("Product not found");
		}
		 
	}

	@Override
	public ProductCatagorie fetchProductCatagorieByName(String name) {
		
		  return productCatagorieDao.findByProductCatagorieNameIgnoreCase(name);
	}
	
	 

}

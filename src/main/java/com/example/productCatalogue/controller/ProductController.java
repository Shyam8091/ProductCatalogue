package com.example.productCatalogue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.productCatalogue.entity.Product;
import com.example.productCatalogue.service.ProductService;

@CrossOrigin("*")
@RestController
@RequestMapping("api/product")
public class ProductController {
	@Autowired
	private ProductService productService;

	@GetMapping("/getAllProductByCatagorie")
	public ResponseEntity<Page<Product>> getAllProductByCatagorie(@RequestParam long id,Pageable page) {
		
		return new ResponseEntity<Page<Product>>(productService.getAllProductByCatagorie(id,page),
				HttpStatus.OK);
	}

}

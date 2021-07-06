package com.example.productCatalogue.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.productCatalogue.dto.ProductCatagorieDto;
import com.example.productCatalogue.entity.ProductCatagorie;
import com.example.productCatalogue.service.ProductCatagorieService;

@CrossOrigin("*")
@RestController
@RequestMapping("api/productCatagories")
public class ProductCatagorieController {
	@Autowired
	private ProductCatagorieService productCatagorieService;

	private final Logger LOGGER = LoggerFactory.getLogger(ProductCatagorieController.class);

	@GetMapping("/getAllProductCatagories")
	public ResponseEntity<Page<ProductCatagorie>> getAllProductCatagories(Pageable page) {
		LOGGER.info("I am from getAllProductCatagories");
		return new ResponseEntity<Page<ProductCatagorie>>(productCatagorieService.getAllProductCatagories(page),
				HttpStatus.OK);
	}

	@PostMapping("/addNewProductCatagorie")
	public ResponseEntity<ProductCatagorie> addNewProductCatagorie(
			@Valid @RequestBody ProductCatagorieDto productCatagorieDto) {

		return new ResponseEntity<ProductCatagorie>(productCatagorieService.addNewProductCatagorie(productCatagorieDto),
				HttpStatus.OK);

	}

	@GetMapping("/findProductCatagorieByid/{id}")
	public ProductCatagorie findProductCatagorieByid(@PathVariable Long id) {
		return productCatagorieService.findProductCatagorieByid(id);
	}

	@PutMapping("/updateProductCatagorie/{id}")
	public ResponseEntity<ProductCatagorie> updateProductCatagorie(@PathVariable Long id,
			@RequestBody ProductCatagorieDto productCatagorieDto) {

		return new ResponseEntity<ProductCatagorie>(
				productCatagorieService.updateProductCatagorie(id, productCatagorieDto), HttpStatus.OK);

	}

	@GetMapping("/productCatagories/name/{name}")
	public ProductCatagorie fetchDepartmentByName(@PathVariable("name") String name) {
		return productCatagorieService.fetchProductCatagorieByName(name);
	}
	
	@GetMapping("/getProductIdANdName")
	public ProductCatagorie getProductIdANdName() {
		return new ProductCatagorie(10L,"TestProduct");
	}
}

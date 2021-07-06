package com.example.productCatalogue.dto;

import java.sql.Timestamp;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ProductCatagorieDto {
	@NotNull
	@Size(min = 3, message = "Product Catagorie Name should contains atleast 2 Characters")
	private String productCatagorieName;
	private String productCatagorieDescription;

	private Timestamp startDate;

	private Timestamp modifiedDate;

	public ProductCatagorieDto() {
		

	}

	public ProductCatagorieDto(
			@NotNull @Size(min = 3, message = "Product Catagorie Name should contains atleast 2 Characters") String productCatagorieName,
			String productCatagorieDescription) {
		super();
		this.productCatagorieName = productCatagorieName;
		this.productCatagorieDescription = productCatagorieDescription;
	}

	public String getProductCatagorieName() {
		return productCatagorieName;
	}

	public void setProductCatagorieName(String productCatagorieName) {
		this.productCatagorieName = productCatagorieName;
	}

	public String getProductCatagorieDescription() {
		return productCatagorieDescription;
	}

	public void setProductCatagorieDescription(String productCatagorieDescription) {
		this.productCatagorieDescription = productCatagorieDescription;
	}

	public Timestamp getStartDate() {
		return startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public Timestamp getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
}

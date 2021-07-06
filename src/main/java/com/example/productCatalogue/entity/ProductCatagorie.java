package com.example.productCatalogue.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class ProductCatagorie {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String productCatagorieName;
	private String productCatagorieDescription;
	@CreationTimestamp
	@Column(updatable = false)
	private Date startDate;
	@UpdateTimestamp
	private Date modifiedDate;
	@OneToMany(targetEntity = Product.class, mappedBy = "productCatagorie")
	@JsonManagedReference
	private List<Product> product;

	public ProductCatagorie() {
	}

	public ProductCatagorie(Long id, String productCatagorieName) {
		this.id = id;
		this.productCatagorieName = productCatagorieName;
	}
	
	public ProductCatagorie(long id, String productCatagorieName, String productCatagorieDescription) {
		super();
		this.id = id;
		this.productCatagorieName = productCatagorieName;
		this.productCatagorieDescription = productCatagorieDescription;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	public long getId() {

		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "IST")
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "IST")
	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}



}

package com.example.ProductCatalogue.controllerTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.productCatalogue.controller.ProductCatagorieController;
import com.example.productCatalogue.dto.ProductCatagorieDto;
import com.example.productCatalogue.entity.ProductCatagorie;
import com.example.productCatalogue.service.ProductCatagorieService;

@WebMvcTest(ProductCatagorieController.class)
public class ProductCatagoriesControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ProductCatagorieService productCatagorieService;

	private ProductCatagorie productCatagorie;

	@BeforeEach
	void setup() {
		productCatagorie = new ProductCatagorie(1L, "test product", "test description");
	}

	@Test
	void addNewProductCatagorieTest() throws Exception {
		ProductCatagorieDto inputProductCatagorie = new ProductCatagorieDto("test product", "test description");
		Mockito.when(productCatagorieService.addNewProductCatagorie(inputProductCatagorie))
				.thenReturn(productCatagorie);
		mockMvc.perform(MockMvcRequestBuilders.post("/api/productCatagories/addNewProductCatagorie")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\r\n" + "\"productCatagorieName\":\"test product\",\r\n"
						+ "\"productCatagorieDescription\":\"test description\"\r\n" + "}"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	void findProductCatagorieByidTest() throws Exception {
		Mockito.when(productCatagorieService.findProductCatagorieByid(1L)).thenReturn(productCatagorie);

		mockMvc.perform(get("/api/productCatagories/findProductCatagorieByid/1").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.productCatagorieName").value(productCatagorie.getProductCatagorieName()));
		
	}
}

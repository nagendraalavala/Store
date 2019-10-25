package com.example.Store;

import com.example.Store.product.ProductEntity;
import com.example.Store.product.ProductService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static javafx.beans.binding.Bindings.when;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class StoreApplicationTests
{
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ProductService productService;

//	@Before()
//	public void setup() throws Exception
//	{
//		mockMvc= MockMvcBuilders.standaloneSetup(productService).build();
//	}

	@Test
	public void testgetAllProducts() throws Exception {

		List<ProductEntity> products = new ArrayList<ProductEntity>();
		products.add(new ProductEntity(1,"Apple1","Apple x1","New Model"));
		products.add(new ProductEntity(2,"Pixal400","Pixal 4","On T mobile deal"));
		given(productService.getAllProducts()).willReturn(products);


		mockMvc.perform(MockMvcRequestBuilders.get("/newstore/allProducts")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect((ResultMatcher) jsonPath("$", hasSize(2))).andDo(print());
	}





}

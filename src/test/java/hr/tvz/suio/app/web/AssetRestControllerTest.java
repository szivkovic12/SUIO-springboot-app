package hr.tvz.suio.app.web;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Calendar;
import java.util.Date;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;

import hr.tvz.suio.app.model.Asset;

@SpringBootTest
@AutoConfigureMockMvc
class AssetRestControllerTest {
	
	@Autowired
	private MockMvc mock;
	@Autowired
	private ObjectMapper mapper;

	@Test
	void testGetAssets() throws Exception {
		this.mock.perform(get("/assets").with(user("admin").password("test").roles("Admin")).with(csrf()))
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.length()", is(4)));
	}
    @Test
	void testFindOne() throws Exception {
		this.mock.perform(get("/assets/1").with(user("admin").password("test").roles("Admin")).with(csrf()))
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.id").value(1));
	}
    @Test
	void testFindOneBySerialNumber() throws Exception {
		this.mock.perform(get("/assets/serialNumber/123456").with(user("admin").password("test").roles("Admin")).with(csrf()))
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.serialNumber").value("123456"));
	}
    @Test
    void testDeleteById() throws Exception {
    	MvcResult result = this.mock.perform(delete("/assets/1").with(user("admin").password("test").roles("Admin")).with(csrf()))
    	.andReturn();
    	assertEquals(204, result.getResponse().getStatus());
    }

	@Test
    void testUpdateAsset() throws Exception {
    	Asset asset = new Asset();
    	asset.setId((long)1);
    	asset.setName("HP");
    	asset.setInventoryNumber("12345");
    	asset.setProductNumber("654321");
    	asset.setSerialNumber("67890");
    	asset.setDateOfDisposal(new Date(2020, Calendar.JULY,11));
    	asset.setStatus("2");
    	asset.setTypeId(1);
    	asset.setDateOfPurchase(new Date(2020, Calendar.AUGUST,11));
    	
    	String assetJsonFormat = this.mapper.writeValueAsString(asset);
    	
    	MvcResult result = this.mock.perform(put("/assets/1").with(user("admin").password("test").roles("Admin")).with(csrf())
        .content(assetJsonFormat).contentType(MediaType.APPLICATION_JSON)).andReturn();
    	assertEquals(204, result.getResponse().getStatus());
    }

	@Test
    void saveAsset() throws Exception {
    	Asset asset = new Asset();
    	asset.setId(null);
    	asset.setName("TOSHIBA");
    	asset.setInventoryNumber("12345");
    	asset.setProductNumber("654321");
    	asset.setSerialNumber("67890");
    	asset.setDateOfDisposal(new Date(2020, Calendar.JULY,11));
    	asset.setStatus("2");
    	asset.setTypeId(1);
    	asset.setDateOfPurchase(new Date(2020, Calendar.AUGUST,11));
    	
    	String assetJsonFormat = this.mapper.writeValueAsString(asset);
    	
    	MvcResult result = this.mock.perform(post("/assets").with(user("admin").password("test").roles("Admin")).with(csrf())
        .content(assetJsonFormat).contentType(MediaType.APPLICATION_JSON)).andReturn();
    	assertEquals(201, result.getResponse().getStatus());
    }
}

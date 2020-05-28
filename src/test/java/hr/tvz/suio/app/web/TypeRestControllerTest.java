package hr.tvz.suio.app.web;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;

import hr.tvz.suio.app.model.Type;

@SpringBootTest
@AutoConfigureMockMvc
class TypeRestControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	//@Autowired
	//private TypeService typeService;
	
	//@MockBean
	//private TypeDAO typeDAO;
		
	@Test
	void testGetAllTypes() throws Exception {
		this.mockMvc.perform(
				get("/type")
				.with(user("admin")
				.password("test")
				.roles("ADMIN"))
				.with(csrf())
				)
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.length()", is(3))); //hasSize(3)_meni_ne_radi
		//when(typeDAO.findAll()).thenReturn((List<Type>) Stream.of(new Type((long) 1, "Tablet")).collect(Collectors.toList()));
		//assertEquals(1, typeService.getAllTypes().size());
		
	}
	
	@Test
	void testGetTypeById() throws Exception {
		Long test_id = (long) 1;
		String test_name = "Laptop";
		
		this.mockMvc.perform(get("/type/"+test_id)
				.with(user("admin")
						.password("test")
						.roles("ADMIN"))
						.with(csrf())
						)
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.id").value(test_id))
		.andExpect(jsonPath("$.name").value(test_name));
	}
	
	@Test
	void testPostType() throws Exception{
		Long TEST_ID = null;
		String TEST_NAME = "Tablet";
		
		Type type = new Type(TEST_ID, TEST_NAME);
		
		this.mockMvc.perform(post("/type")
				.with(user("admin")
						.password("test")
						.roles("ADMIN"))
						.with(csrf())						
				.content(objectMapper.writeValueAsString(type))
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
	}
	
	@Test
    void testPutType() throws Exception {
    	Type type = new Type();
    	type.setId((long)1);
    	type.setName("Mobitel");
  	
    	this.mockMvc.perform(put("/type/update/2")
    			.with(user("admin")
    					.password("test").
    					roles("ADMIN"))
    			.with(csrf()
    					)
    			.content(objectMapper.writeValueAsString(type))
    			.contentType(MediaType.APPLICATION_JSON))
    	.andExpect(status().isOk());
    }
	
	@Test
	void testDeleteById() throws Exception {
	   MvcResult deleted = this.mockMvc.perform(delete("/type/delete/3")
	    						.with(user("admin")
	    						.password("test")
	    						.roles("ADMIN"))
	    						.with(csrf())
	    						)
	    .andReturn();
	    assertEquals(200, deleted.getResponse().getStatus());
	    }

}

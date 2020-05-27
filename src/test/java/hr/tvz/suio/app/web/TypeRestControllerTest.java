package hr.tvz.suio.app.web;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;

import hr.tvz.suio.app.dao.TypeDAO;
import hr.tvz.suio.app.dao.TypeDTO;
import hr.tvz.suio.app.dao.TypeService;
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
		this.mockMvc.perform(get("/type"))
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
		
		this.mockMvc.perform(get("/type/"+test_id))
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
				.content(objectMapper.writeValueAsString(type))
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
	}

}

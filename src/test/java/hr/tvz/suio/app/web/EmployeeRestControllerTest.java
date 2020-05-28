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


import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;

import hr.tvz.suio.app.model.Employee;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeRestControllerTest {

	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	void testGetEmployees() throws Exception {
		this.mockMvc.perform(
				get("/employee")
				.with(user("admin")
				.password("test")
				.roles("ADMIN"))
				.with(csrf()))
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.length()", is(3)));

	}
	
	@Test
	void testFindById() throws Exception {
		this.mockMvc.perform
				(get("/employee/1")
				.with(user("admin")
				.password("test")
				.roles("ADMIN"))
				.with(csrf()))
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.id").value(1));
	
	}
	
	@Test
	void testDeleteById() throws Exception {
	    MvcResult result = this.mockMvc.perform
	    						(delete("/employee/3")
	    						.with(user("admin")
	    						.password("test").roles("ADMIN")).with(csrf()))
	    						.andReturn();
	    						assertEquals(204, result.getResponse().getStatus());
	    }
	  

	@Test
	void testEditEmployee() throws Exception {
	    	Employee employee = new Employee();
	    	employee.setId((long)2);
	    	employee.setName("Denis");
	    	employee.setSurname("Deno");
	    	employee.setOib("89898989891");
	    	employee.setEmail("denis@tvz.hr");
	    	employee.setDate_of_birth(new Date(2000, Calendar.MAY,12));
	    	employee.setDepartment(1);
	    	employee.setRole(2);
	    	employee.setDate_of_employment(new Date(2020, Calendar.MAY,12));
	    	
	    	String employeeJsonFormat = this.mapper.writeValueAsString(employee);
	    	
	    	MvcResult result = this.mockMvc.perform
	    			(put("/employee/2")
	    			.with(user("admin")
	    			.password("test")
	    			.roles("ADMIN"))
	    			.with(csrf())
	    			.content(employeeJsonFormat).contentType(MediaType.APPLICATION_JSON)).andReturn();
	    			assertEquals(200, result.getResponse().getStatus());
	    }
	
	
	@Test
    void saveEmployee() throws Exception {
    	
		Employee employee = new Employee();
    	employee.setId(null);
    	employee.setName("Marko");
    	employee.setSurname("Marić");
    	employee.setOib("99887788991");
    	employee.setEmail("mm@tvz.hr");
    	employee.setDate_of_birth(new Date(1998, Calendar.MAY,12));
    	employee.setDepartment(1);
    	employee.setRole(2);
    	employee.setDate_of_employment(new Date(2020, Calendar.AUGUST,12));
		
    	String employeeJsonFormat = this.mapper.writeValueAsString(employee);
    	
    	MvcResult result = this.mockMvc.perform
    			(post("/employee")
    			.with(user("admin")
    			.password("test")
    			.roles("ADMIN"))
    			.with(csrf())
    			.content(employeeJsonFormat).contentType(MediaType.APPLICATION_JSON)).andReturn();
    			assertEquals(201, result.getResponse().getStatus());
    }
	
}

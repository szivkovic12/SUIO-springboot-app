package hr.tvz.suio.app.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hr.tvz.suio.app.dao.EmployeeDTO;
import hr.tvz.suio.app.dao.EmployeeService;

@RestController
@RequestMapping("employee")
public class EmployeeRestController {
	
	@Autowired
	EmployeeService employeeService;

	@GetMapping
	public List<EmployeeDTO> getAll(){
		return employeeService.getAll();
		
	}
	
	

}

package hr.tvz.suio.app.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import hr.tvz.suio.app.dao.EmployeeDTO;
import hr.tvz.suio.app.dao.EmployeeService;
import hr.tvz.suio.app.model.Employee;



@RestController
@RequestMapping("employee")
@CrossOrigin(origins="http://localhost:4200")
public class EmployeeRestController {
	
	@Autowired
	EmployeeService employeeService;

	
	@GetMapping
	public List<EmployeeDTO> getAll(){
		return employeeService.getAll();
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EmployeeDTO> findEmployeeById(@PathVariable Long id){
	return employeeService.findById(id)
	.map(ResponseEntity::ok)
    .orElseGet(
            () -> ResponseEntity.notFound().build()
    );
	}
	
	@ResponseStatus(HttpStatus.OK)
	@PutMapping("/{id}")
	public void update(@PathVariable Long id, @RequestBody Employee employee){
		 employeeService.updateEmployee(id,employee);
			
	}
	
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public void createEmployee(@RequestBody Employee employee){
		employeeService.createEmployee(employee);
		
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id){
		employeeService.deleteById(id);
	}	
}

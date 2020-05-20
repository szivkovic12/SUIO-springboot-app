package hr.tvz.suio.app.dao;

import java.util.List;
import java.util.Optional;
import hr.tvz.suio.app.model.Employee;

public interface EmployeeService {

	List<EmployeeDTO> getAll();
	
	Optional<EmployeeDTO> findById(Long id);
	
	void updateEmployee(Long id, Employee employee);
	
	void createEmployee(Employee employee);
	
	void deleteById(Long id);
	
}

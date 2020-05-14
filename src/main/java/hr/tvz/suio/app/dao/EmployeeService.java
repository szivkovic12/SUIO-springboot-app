package hr.tvz.suio.app.dao;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

	List<EmployeeDTO> getAll();
	Optional<EmployeeDTO> createEmployee();
	Optional<EmployeeDTO> updateEmployee();
	Optional<EmployeeDTO> findById(String id);
	void deleteById(String id);
	
}

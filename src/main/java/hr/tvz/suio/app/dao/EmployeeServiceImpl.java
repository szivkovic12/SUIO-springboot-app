package hr.tvz.suio.app.dao;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.tvz.suio.app.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeDAO employeeDAO;
	
	@Override
	public List<EmployeeDTO> getAll() {
		return employeeDAO.findAll().stream().map(this::mapEmployeeToDTO).collect(Collectors.toList());
	}
	
	@Override
	public Optional<EmployeeDTO> findById(Long id) {
		return employeeDAO.findById(id).map(this::mapEmployeeToDTO);
	}

	@Override
	public void updateEmployee(Long id, Employee employee) {
		employeeDAO.updateEmployeeById(employee.getName(), employee.getSurname(),employee.getOib(), employee.getEmail(),employee.getDate_of_birth(),
				employee.getDepartment(), employee.getRole(),employee.getDate_of_employment(), id);
				
	}
	
	@Override
	public void createEmployee(Employee employee) {
		 employeeDAO.save(employee);
		
	}

	@Override
	public void deleteById(Long id) {
		employeeDAO.deleteById(id);
		
	}

	private EmployeeDTO mapEmployeeToDTO(Employee employee) {
		return new EmployeeDTO(employee.getName(), employee.getSurname(), employee.getOib(),employee.getEmail(),
		employee.getDate_of_birth(),employee.getDepartment(), employee.getRole(), employee.getDate_of_employment());
	}	
	
	
}

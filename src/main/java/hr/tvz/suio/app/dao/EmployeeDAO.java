package hr.tvz.suio.app.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import hr.tvz.suio.app.model.Employee;

public interface EmployeeDAO extends JpaRepository<Employee, Long>{

	List<Employee> findAll();
	
}

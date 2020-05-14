package hr.tvz.suio.app.dao;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import hr.tvz.suio.app.model.Employee;
@Transactional
@Repository
public interface EmployeeDAO extends JpaRepository<Employee, Long>{
	
	
	List<Employee> findAll();
	Optional<Employee> findById(Long id);
	
	@Modifying
	@Query("update Employee e set e.name = ?1, e.surname = ?2, e.oib = ?3,e.email=?4,e.date_of_birth=?5,e.department=?6,e.role=?7,e.date_of_employment=?8 where e.id = ?9")
	void updateEmployeeById(String name, String surname,String oib, String email, Date date_of_birth, Integer department, Integer role, Date date_of_employment,Long id);
	
}

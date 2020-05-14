package hr.tvz.suio.app.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
//	@ManyToOne(targetEntity = Employee.class)
//	@JoinTable(name="employee",
//	joinColumns = {@JoinColumn(name="department_id")}
//	)
//	private List<Employee> employees;
	
}

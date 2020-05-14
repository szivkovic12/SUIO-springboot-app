package hr.tvz.suio.app.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;


@Data
@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String surname;
	private String oib;
	private String email;
	private Date date_of_birth;
	//@OneToMany(targetEntity = Department.class, mappedBy = "employees")
	@Column(name="department_id")
	private Integer department;
	@Column(name="role_id")
	private Integer role;
	private Date date_of_employment;
}

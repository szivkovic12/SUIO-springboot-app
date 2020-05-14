package hr.tvz.suio.app.dao;

import java.util.Date;
import lombok.Data;
@Data
public class EmployeeDTO {
	
	


	private String name;
	private String surname;
	private String oib;
	private String email;
	private Date date_of_birth;
	private Integer department;
	private Integer role;
	private Date date_of_employment;
	
	public EmployeeDTO(String name, String surname, String oib, String email, Date date_of_birth,
			Integer department, Integer role, Date date_of_employment) {
		this.name=name;
		this.surname=surname;
		this.oib=oib;
		this.email=email;
		this.date_of_birth=date_of_birth;
		this.department=department;
		this.role=role;
		this.date_of_employment=date_of_employment;
	}
	
}

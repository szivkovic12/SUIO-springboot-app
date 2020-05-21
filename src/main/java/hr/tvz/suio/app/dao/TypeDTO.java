package hr.tvz.suio.app.dao;

import lombok.Data;

@Data
public class TypeDTO {

	private Long id;
	private String name;

	public TypeDTO(Long id, String name) {
		this.setId(id);
		this.setName(name);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
		
}

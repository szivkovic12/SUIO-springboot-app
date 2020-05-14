package hr.tvz.suio.app.dao;

import lombok.Data;

@Data
public class TypeDTO {

	private String name;

	public TypeDTO(String name) {
		this.name=name;
	}
		
}

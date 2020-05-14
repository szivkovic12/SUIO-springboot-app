package hr.tvz.suio.app.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import hr.tvz.suio.app.dao.TypeDTO;
import hr.tvz.suio.app.dao.TypeService;
import hr.tvz.suio.app.model.Type;

@RestController
@RequestMapping("type")
public class TypeRestController {
	
	@Autowired
	private TypeService typeService;
	
	@GetMapping
	public List<TypeDTO> getAllTypes() {
		return typeService.getAllTypes();
	}
	
	
}

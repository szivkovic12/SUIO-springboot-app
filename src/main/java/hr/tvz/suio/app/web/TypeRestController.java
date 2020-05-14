package hr.tvz.suio.app.web;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hr.tvz.suio.app.dao.TypeDTO;
import hr.tvz.suio.app.dao.TypeService;
import hr.tvz.suio.app.model.Type;

@RestController
@RequestMapping("type")
public class TypeRestController {
	
	@Autowired
	TypeService typeService;
	
	@GetMapping
	public List<TypeDTO> getAllTypes() {
		return typeService.getAllTypes();
	}
	
	@GetMapping("/{id}")
	public Optional<TypeDTO> findType(@PathVariable Long id){
		return typeService.findById(id);
	}
	
	@PostMapping("/add")
	public void newType(@RequestBody Type type) {
		typeService.createType(type);
	}
	
	@PutMapping("/update/{id}")
	public void updateType(@PathVariable Long id, @RequestBody Type type) {
		typeService.updateType(type, id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteType(@PathVariable Long id) {
		typeService.deleteById(id);
	}
}

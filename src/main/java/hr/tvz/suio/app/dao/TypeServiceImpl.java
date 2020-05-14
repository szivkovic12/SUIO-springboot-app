package hr.tvz.suio.app.dao;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.tvz.suio.app.model.Type;

@Service
public class TypeServiceImpl implements TypeService{
	
	@Autowired
	TypeDAO typeDAO;

	@Override
	public List<TypeDTO> getAllTypes() {
		return typeDAO.findAll().stream().map(this::mapTypeToDTO).collect(Collectors.toList());
	}

	@Override
	public void createType(Type type) {
		typeDAO.save(type);
	}

	@Override
	public void updateType(Type type, Long id) {
		typeDAO.updateTypeById(type.getName(), id);
	}

	@Override
	public Optional<TypeDTO> findById(Long id) {
		return typeDAO.findById(id).map(this::mapTypeToDTO);
	}

	@Override
	public void deleteById(Long id) {
		typeDAO.deleteById(id);
		
	}
	
	private TypeDTO mapTypeToDTO(Type type) {
		return new TypeDTO(type.getName());
	}

}

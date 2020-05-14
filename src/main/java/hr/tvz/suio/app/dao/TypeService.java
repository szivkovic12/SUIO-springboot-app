package hr.tvz.suio.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import hr.tvz.suio.app.model.Type;

@Service
public interface TypeService {

	List<TypeDTO> getAllTypes();
	void createType(Type type);
	void updateType(Type type, Long id);
	Optional<TypeDTO> findById(Long id);
	void deleteById(Long id);

}

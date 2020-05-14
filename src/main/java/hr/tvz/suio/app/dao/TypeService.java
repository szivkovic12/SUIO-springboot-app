package hr.tvz.suio.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public interface TypeService {

	List<TypeDTO> getAllTypes();
	Optional<TypeDTO> createType();
	Optional<TypeDTO> updateType();
	Optional<TypeDTO> findById(Long id);
	void deleteById(Long id);

}

package hr.tvz.suio.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeServiceImpl implements TypeService{
	
	@Autowired
	TypeDAO typeDAO;

	@Override
	public List<TypeDTO> getAllTypes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<TypeDTO> createType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<TypeDTO> updateType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<TypeDTO> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

}

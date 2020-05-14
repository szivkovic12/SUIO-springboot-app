package hr.tvz.suio.app.dao;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import hr.tvz.suio.app.model.Type;

@Transactional
public interface TypeDAO extends JpaRepository<Type, Long>{

		List<Type> findAll();
		Optional<Type> findById(Long id);
		
		@Modifying
		@Query("update Type e set e.name = ?1 where e.id = ?2")
		void updateTypeById(String name, Long id);

}

package hr.tvz.suio.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hr.tvz.suio.app.model.Type;

public interface TypeDAO extends JpaRepository<Type, Long>{

		List<Type> findAll();

}

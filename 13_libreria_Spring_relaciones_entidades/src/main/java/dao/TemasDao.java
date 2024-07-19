package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.Tema;

public interface TemasDao extends JpaRepository<Tema, Integer> {// Spring ya tiene find by id con lo que no lo hago
	
	

}

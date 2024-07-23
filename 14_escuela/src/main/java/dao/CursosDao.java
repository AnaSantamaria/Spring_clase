package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.Curso;

public interface CursosDao extends JpaRepository<Curso, Integer> {
	
	

}

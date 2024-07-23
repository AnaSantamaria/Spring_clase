package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.Curso;

public interface CursosDao extends JpaRepository<Curso, Integer> {
	
	List<Curso> findBynombre(String nombre);
	List <Curso> cursosSinUsuario();
	

}

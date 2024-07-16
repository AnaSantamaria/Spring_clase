package dao;

import java.util.List;

import model.Curso;

public interface CursosDao {

	
	
	void save(Curso curso);
	Curso findByNombre(String nombre);
	void deleteByNombre (String nombre);
	List<Curso> findByPrecipoMax(Double precio);
}

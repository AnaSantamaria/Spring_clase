package service;

import java.util.ArrayList;
import java.util.List;

import model.Curso;

public interface CursosService {
	
	boolean nuevo(Curso curso);

	List<Curso> preciosCursoMax(double precioMax);

	void eliminarCurso(String nombre);
}

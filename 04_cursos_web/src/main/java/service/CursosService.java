package service;

import java.util.ArrayList;

import model.Curso;

public interface CursosService {
	
	boolean guardar(Curso curso);
	ArrayList<Curso> preciosCursoMax(double precioMax);
	void eliminarCurso(String nombre);
	
}

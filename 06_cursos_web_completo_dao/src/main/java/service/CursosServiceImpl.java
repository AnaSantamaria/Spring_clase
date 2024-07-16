package service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.CursosDao;
import model.Curso;
@Service
public class CursosServiceImpl implements CursosService {
	@Autowired
	CursosDao cursosDao;
	
	
	
		

	@Override
	public List<Curso> preciosCursoMax(double precioMax) {
		return cursosDao.findByPrecipoMax(precioMax);
			
		
	}
		
	
	
	@Override
	public void eliminarCurso(String nombre) {
		cursosDao.deleteByNombre(nombre);

	}


	@Override
	public boolean nuevo(Curso curso) {
		if(cursosDao.findByNombre(curso.getNombre())==null) {
			cursosDao.save(curso);
			return true;
		}
		return false;
	}

	
		

	}



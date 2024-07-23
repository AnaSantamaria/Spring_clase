package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.Alumno;

public interface AlumnosDao extends JpaRepository <Alumno, String> {
	
	List<Alumno> findByMatricula();
	List<Alumno> findByFecha();

}

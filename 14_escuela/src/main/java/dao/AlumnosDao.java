package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.Alumno;

public interface AlumnosDao extends JpaRepository <Alumno, String> {
	
	

}

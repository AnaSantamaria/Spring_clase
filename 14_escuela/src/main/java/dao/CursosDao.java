package dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import entities.Curso;

public interface CursosDao extends JpaRepository<Curso, Integer> {
	@Query("select c from Curso c join c.alumnos a where a.usuario=?1")
	List<Curso> findByUsuario(String usuario);
	@Query("select c from Curso c where c not in (select c from Curso c join c.alumnos a where a.usuario=?1)")
	List<Curso> findByNoMatriculado(String usuario);
<<<<<<< HEAD
=======
	
	
	@Query("select c from Curso c where c.nombre=?1")
	List<Curso> findByName(String nombre);
	
	
	//@Query("select c from Curso c where c.nombre = :nombre and c.fechaInicio = :fechaInicio") Esta instruccion no es necesaria
    List<Curso> findByNombreAndFechaInicio(String name, LocalDate fecha);
	
	
>>>>>>> branch 'master' of https://github.com/AnaSantamaria/Spring_clase.git

}

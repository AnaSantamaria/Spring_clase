package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import entities.Matricula;
import entities.MatriculaPk;

public interface MatriculasDao extends JpaRepository<Matricula, MatriculaPk> {
	
	@Query("select avg(m.nota) from Matricula m where m.curso.idCurso=?1" )
	double avgByIdCurso (int idCurso);// avg es la media
	@Query("select avg(m.nota) from Matricula m where m.alumno.usuario=?1")
	double avgByUsuario(String usuario);
	@Query("select l from Matricula l where l.matricula.nota=?1")
	double findnota(double nota );

}

package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import entities.Libro;

public interface LibrosDao extends JpaRepository<Libro, Integer> {
	
	List<Libro> findByIdTema(int idTema);
	@Query("select 1 from Libro 1 where 1.tema.tema=?1")
	List<Libro> findByPrecioBetween(double pMin, double pMax);// ejemplo de metodos que hace espring solo con escribirlos
}

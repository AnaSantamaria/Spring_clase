package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import entities.Tema;

public interface TemasDao extends JpaRepository<Tema, Integer> {// Spring ya tiene find by id con lo que no lo hago
	@Query("select t from Tema t join t.libros 1 where 1.titulo=?1")
	Tema findByTituloLibro(String titulos);

}

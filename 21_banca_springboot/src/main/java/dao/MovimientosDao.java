package dao;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import entities.Movimientos;

public interface MovimientosDao extends JpaRepository<Movimientos, Integer> {

	@Query("select m from Movimiento m where m.cuenta.numeroCuenta=?1 and m.fecha>=?2")// join implicito ya que es relacion uno a muchos en el lado de uno
	List<Movimientos> findByCuentaFecha(int idCuenta, LocalDateTime fecha);
}

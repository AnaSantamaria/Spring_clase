package dao;

import java.util.List;

/*Funcionalidades aplicación banca:

-Validar cuenta: A partir del numero cuenta proporcionado por el usuario, nos indicará si la cuaenta
existe
-Ingreso: A partir del número de cuenta y cantidad, se realizará la operación de ingreso
-Extracción: A partir del número de cuenta y cantidad, se realizará la operación de extracción
-Transferencia: A partir de número de cuenta origen, número de cuenta destino y cantidad, se realizará la transferencia
-Consulta de movimientos: A partir del número de cuenta y fecha se informará de los movimientos
de esa cuenta, posteriores a la fecha indicada
-Consulta de titulares: A partir del número de cuenta, se informará de los titulares (clientes) a los
que pertenezca dicha cuenta*/

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import entities.Clientes;

public interface ClientesDao extends JpaRepository<Clientes, Integer> {
	
	@Query("select c from Clientes c join c.cuentas q where q.numeroCuenta=?1  ")
	List<Clientes> findByNumeroDeCuenta(int numeroCuenta);
	
	

}

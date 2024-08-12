package dao;


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

import entities.Cuentas;

public interface CuentasDao extends JpaRepository<Cuentas, Integer> {// en cuentasDao no hago nada ya que todo lo que afecta a las cuentas es metodos Save o Update que ya vienen implementados en Spring
	
	

}

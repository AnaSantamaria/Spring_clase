package utilidades;

import org.springframework.stereotype.Component;

import entities.Clientes;
import entities.Cuentas;
import entities.Movimientos;
import model.ClienteDto;
import model.CuentaDto;
import model.MovimientoDto;
@Component
public class Mapeador {
	
	/*public ClienteDto clientesEntityToDto( Clientes cliente)  {
		
		return new clienteDto()
		
		
	}*/
	
	public MovimientoDto movimientosEntityToDto(Movimientos movimiento) {
		
		return new MovimientoDto(movimiento.getIdMovimiento(),
									movimiento.getIdCuenta(),
									movimiento.getFecha().toLocalDate(),
									movimiento.getCantidad(),
									movimiento.getOperacion()
						);
		
		
	}
	
	public CuentaDto cuentasEntityToDto(Cuentas cuenta) {
		
		return new CuentaDto (cuenta.getNumeroCuenta(),
								cuenta.getSaldo(),
								cuenta.getTipoCuenta());
		
		
	}
	
	
	 public ClienteDto clienteEntityToDto(Clientes cliente) {
	        return new ClienteDto(
	                cliente.getDni(),
	                cliente.getNombre(),
	                cliente.getDireccion(),
	                cliente.getTelefono()
	        );
	    }

}

package service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dao.ClientesDao;
import dao.CuentasDao;
import dao.MovimientosDao;
import entities.Cuentas;
import entities.Movimientos;
import model.ClienteDto;
import model.CuentaDto;
import model.MovimientoDto;
import utilidades.Mapeador;

@Service
public class BancaServiceImpl implements BancaService {

	CuentasDao cuentasDao;
	MovimientosDao movimientosDao;
	ClientesDao clientesDao;
	Mapeador mapeador;

	public BancaServiceImpl(CuentasDao cuentasDao, ClientesDao clientesDao, Mapeador mapeador,
			MovimientosDao movimientosDao) {
		super();
		this.cuentasDao = cuentasDao;
		this.clientesDao = clientesDao;
		this.mapeador = mapeador;
		this.movimientosDao = movimientosDao;
	}

	@Override
	public boolean validarCuenta(int numeroCuenta) {

		return cuentasDao.existsById(numeroCuenta);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void ingreso(int numeroCuenta, double cantidad) {

		Cuentas cuenta = cuentasDao.findById(numeroCuenta).orElse(null);
		if (cuenta != null) {

			cuenta.setSaldo(cuenta.getSaldo() + cantidad);
			operacion(cantidad, "ingreso", cuenta);
		} else {
			throw new RuntimeException();
		}

	}

	@Transactional(propagation = Propagation.REQUIRED) // Required es por defecto
	@Override
	public void extraccion(int numeroCuenta, double cantidad) {

		Cuentas cuenta = cuentasDao.findById(numeroCuenta).orElse(null);
		if (cuenta.getSaldo()>= cantidad) {

			cuenta.setSaldo(cuenta.getSaldo() - cantidad);
			operacion(cantidad, "extraccion", cuenta);
		} else {
			throw new RuntimeException();
		}
	}

	public void operacion(double cantidad, String operacion, Cuentas cuenta) {
		
		Movimientos movimiento = new Movimientos();
		
	    movimiento.setFecha(LocalDateTime.now());
	    movimiento.setCantidad(cantidad);;
	    movimiento.setOperacion(operacion);
	    
		movimientosDao.save(movimiento);

		cuentasDao.save(cuenta);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void transferencia(int numeroCuentaOrigen, int numeroCuentaDestino, double cantidad) {

		ingreso(numeroCuentaDestino, cantidad);
		extraccion(numeroCuentaOrigen, cantidad);

	}

	@Override
	public List<ClienteDto> titularesCuenta(int numeroCuenta) {
		if (validarCuenta(numeroCuenta)) {

			return clientesDao.findByNumeroDeCuenta(numeroCuenta).stream().map(c -> mapeador.clienteEntityToDto(c))
					.toList();
		} else {

			throw new RuntimeException();
		}

	}

	@Override
	public List<MovimientoDto> movimientosCuentaFecha(int numeroCuenta, LocalDateTime fecha) {
		if (validarCuenta(numeroCuenta)) {

			return movimientosDao.findByCuentaFecha(numeroCuenta, fecha).stream()
					.map(m -> mapeador.movimientoEntityToDto(m)).toList();
		}else {
			throw new RuntimeException();
		}
	

	}

	@Override
	public CuentaDto getCuenta(int numeroCuenta) {
		
		return mapeador.cuentasEntityToDto(cuentasDao.findByNumeroCuenta(numeroCuenta));
	}

}

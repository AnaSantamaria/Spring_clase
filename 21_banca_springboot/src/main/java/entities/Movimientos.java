package entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "movimientos")

public class Movimientos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMovimiento;
	
	private LocalDateTime fecha;
	private double cantidad;
	private String operacion;
	@ManyToOne
	@JoinColumn(name = "idCuenta", referencedColumnName = "numeroCuenta" )
	private Cuentas cuenta;
	
	


	

	public Movimientos(int idMovimiento, LocalDateTime fecha, double cantidad, String operacion, Cuentas cuenta) {
		super();
		this.idMovimiento = idMovimiento;
		this.fecha = fecha;
		this.cantidad = cantidad;
		this.operacion = operacion;
		this.cuenta = cuenta;
	}


	public Movimientos() {
		super();
	}


	public int getIdMovimiento() {
		return idMovimiento;
	}


	public void setIdMovimiento(int idMovimiento) {
		this.idMovimiento = idMovimiento;
	}



	public LocalDateTime getFecha() {
		return fecha;
	}


	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}


	public double getCantidad() {
		return cantidad;
	}


	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}


	public String getOperacion() {
		return operacion;
	}


	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}


	public Cuentas getCuenta() {
		return cuenta;
	}


	public void setCuenta(Cuentas cuenta) {
		this.cuenta = cuenta;
	}


	
	
	

}

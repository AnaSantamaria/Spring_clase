package entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "movimientos")

public class Movimientos {
	@Id
	private int idMovimiento;
	private int idCuemta;
	private LocalDate fecha;
	private double cantidad;
	private String operacion;
	@ManyToOne
	@JoinColumn(name = "idCuenta", referencedColumnName = "numeroCuenta" )
	private Cuentas cuenta;
	public Movimientos() {
		super();
	}


	public Movimientos(int idMovimiento, int idCuemta, LocalDate fecha, double cantidad, String operacion) {
		super();
		this.idMovimiento = idMovimiento;
		this.idCuemta = idCuemta;
		this.fecha = fecha;
		this.cantidad = cantidad;
		this.operacion = operacion;
	}


	public int getIdMovimiento() {
		return idMovimiento;
	}


	public void setIdMovimiento(int idMovimiento) {
		this.idMovimiento = idMovimiento;
	}


	public int getIdCuemta() {
		return idCuemta;
	}


	public void setIdCuemta(int idCuemta) {
		this.idCuemta = idCuemta;
	}


	public LocalDate getFecha() {
		return fecha;
	}


	public void setFecha(LocalDate fecha) {
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
	
	

}

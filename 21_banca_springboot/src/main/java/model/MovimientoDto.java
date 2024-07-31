package model;

import java.time.LocalDate;

public class MovimientoDto {
	
	private int idMovimiento;
	private int idCuenta;
	private LocalDate fecha;
	private double cantidad;
	private String operacion;
	
	
	public MovimientoDto() {
		super();
	}


	public MovimientoDto(int idMovimiento, int idCuenta, LocalDate fecha, double cantidad, String operacion) {
		super();
		this.idMovimiento = idMovimiento;
		this.idCuenta = idCuenta;
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
		return idCuenta;
	}


	public void setIdCuemta(int idCuemta) {
		this.idCuenta = idCuenta;
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

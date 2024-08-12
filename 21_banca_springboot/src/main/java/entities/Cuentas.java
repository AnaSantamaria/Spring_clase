package entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name= "cuentas")
public class Cuentas {
	@Id
	private int numeroCuenta;
	private double saldo;
	@Column(name="tipocuenta")
	private String tipoCuenta;
	@ManyToMany()
	@JoinTable( name ="titulares", joinColumns = @JoinColumn(name = "idCuenta", referencedColumnName = "numeroCuenta"),
									inverseJoinColumns = @JoinColumn(name = "idCliente", referencedColumnName= "dni"))
	private List<Clientes> clientes;
	
	@OneToMany(mappedBy="cuenta")
	private List<Movimientos> movimientos;
	
	public Cuentas(int numeroCuenta, double saldo, String tipoCuenta) {
		super();
		this.numeroCuenta = numeroCuenta;
		this.saldo = saldo;
		this.tipoCuenta = tipoCuenta;
	}


	public Cuentas() {
		super();
	}


	public int getNumeroCuenta() {
		return numeroCuenta;
	}


	public void setNumeroCuenta(int numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}


	public double getSaldo() {
		return saldo;
	}


	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}


	public String getTipoCuenta() {
		return tipoCuenta;
	}


	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}
	
	

}

package entities;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="clientes")

public class Cliente {
	@Id
	private int idCliente;
	private String usuario;
	private String password;
	private String email;
	private int tlf;
	
	
	public Cliente() {
		super();
	}


	public Cliente(int idCliente, String usuario, String password, String email, int tlf) {
		super();
		this.idCliente = idCliente;
		this.usuario = usuario;
		this.password = password;
		this.email = email;
		this.tlf = tlf;
	}


	public int getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getTlf() {
		return tlf;
	}


	public void setTlf(int tlf) {
		this.tlf = tlf;
	}
	
	

}

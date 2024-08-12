package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="resultados")

public class Resultado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idresultados;
	private String url;
	private String tematica;
	private String descripcion;
	
	
	public Resultado(int idresultados, String url, String tematica, String descripcion) {
		super();
		this.idresultados = idresultados;
		this.url = url;
		this.tematica = tematica;
		this.descripcion = descripcion;
	}


	public Resultado() {
		super();
	}


	public int getIdResultado() {
		return idresultados;
	}


	public void setIdResultado(int idresultados) {
		this.idresultados = idresultados;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public String getTematica() {
		return tematica;
	}


	public void setTematica(String tematica) {
		this.tematica = tematica;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}

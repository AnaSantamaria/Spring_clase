package entities;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="temas")


public class Tema {
	@Id
	public int idTema;
	public String Tema;
	
	public Tema() {
		super();
	}

	public Tema(int idTema, String tema) {
		super();
		this.idTema = idTema;
		Tema = tema;
	}

	public int getIdTema() {
		return idTema;
	}

	public void setIdTema(int idTema) {
		this.idTema = idTema;
	}

	public String getTema() {
		return Tema;
	}

	public void setTema(String tema) {
		Tema = tema;
	}

}

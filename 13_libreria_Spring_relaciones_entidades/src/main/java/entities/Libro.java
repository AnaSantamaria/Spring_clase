package entities;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="libros")
public class Libro {
	@Id
	public int isbn;
	public String titulo;
	public String autor;
	public double precio;
	public int paginas;
	public int idTema;
	
	
	public Libro() {
		super();
	}


	public Libro(int isbn, String titulo, String autor, double precio, int paginas, int idTema) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.precio = precio;
		this.paginas = paginas;
		this.idTema = idTema;
	}


	public int getIsbn() {
		return isbn;
	}


	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getAutor() {
		return autor;
	}


	public void setAutor(String autor) {
		this.autor = autor;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public int getPaginas() {
		return paginas;
	}


	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}


	public int getIdTema() {
		return idTema;
	}


	public void setIdTema(int idTema) {
		this.idTema = idTema;
	}
	
	

}

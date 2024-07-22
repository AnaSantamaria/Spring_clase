package entities;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "ventas" )
public class Venta {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int idVenta;
@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name="idCliente",referencedColumnName = "idCliente")
private Cliente cliente;
@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name="idLibro",referencedColumnName = "isbn")
private Libro libro;
//La siguiente anotación es conveniente si usamos como campo de fecha un java.util.Date
//@Temporal(TemporalType.TIMESTAMP)
private LocalDateTime fecha;


public Venta() {
	super();
}


public Venta(int idVenta, Cliente cliente, Libro libro, LocalDateTime fecha) {
	super();
	this.idVenta = idVenta;
	this.cliente = cliente;
	this.libro = libro;
	this.fecha = fecha;
}


public int getIdVenta() {
	return idVenta;
}


public void setIdVenta(int idVenta) {
	this.idVenta = idVenta;
}


public Cliente getCliente() {
	return cliente;
}


public void setCliente(Cliente cliente) {
	this.cliente = cliente;
}


public Libro getLibro() {
	return libro;
}


public void setLibro(Libro libro) {
	this.libro = libro;
}


public LocalDateTime getFecha() {
	return fecha;
}


public void setFecha(LocalDateTime fecha) {
	this.fecha = fecha;
}



}

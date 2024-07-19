package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.Cliente;

public interface ClientesDao extends JpaRepository<Cliente, String> {
	
	Cliente findByUsuario(String usuario);// el metodo save ya viene implementado por Spring asique no lo hago

}

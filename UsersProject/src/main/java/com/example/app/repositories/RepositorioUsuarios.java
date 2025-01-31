package com.example.app.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.app.models.Usuario;

@Repository
public interface RepositorioUsuarios extends CrudRepository<Usuario, Long>{
	// JPA -> Permitir de manera dinámica crear queries
	List<Usuario> findAll(); // SELECT * FROM usuarios

	// INSERT INTO usuarios(nombre, apellido...) VALUES (Valores de los atributos)
	// UPDATE usuarios SET nombre = Valor objeto...
	Usuario save(Usuario nuevoUsuario); // Usuario cynthia = new Usuario(); (ejemplo)

	// CrudRepository: findAll(), findById(), save(Object objeto), deleteById()
	// SELECT * FROM usuarios WHERE email = <email a buscar>
	List<Usuario> findByEmail(String emailABuscar);

	List<Usuario> findByApellido(String apellidoABuscar);

	// SELECT * FROM usuarios WHERE nombre LIKE "<letras>%"
	List<Usuario> findByNombreStartingWith(String letrasABuscar);
}

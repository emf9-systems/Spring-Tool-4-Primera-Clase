package com.example.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.models.Salon;
import com.example.app.models.Usuario;
import com.example.app.repositories.RepositorioSalones;
import com.example.app.repositories.RepositorioUsuarios;

@Service
public class Servicios {
	
	@Autowired
	private RepositorioUsuarios repoUsuarios;
	
	@Autowired
	private RepositorioSalones repoSalones;

	// Métodos para Usuarios
	public List<Usuario> todosUsuarios() {
		return repoUsuarios.findAll();
	}
	
	public Usuario guardarUsuario(Usuario nuevoUsuario) {
		return repoUsuarios.save(nuevoUsuario);
	}

	public Usuario buscarUsuario(Long id) {
		return repoUsuarios.findById(id).orElse(null);
	}
	
	public void borrarUsuario(Long id) {
		repoUsuarios.deleteById(id);
	}

	// Métodos para Salones
	public List<Salon> todosLosSalones() {
		List<Salon> salones = repoSalones.findAll();
		// Asegurarse de que se cargue la lista de usuarios
		for (Salon salon : salones) {
			salon.getUsuarios().size(); // Esto fuerza la carga de los usuarios
		}
		return salones;
	}
	
	public Salon buscarSalon(Long id) {
		return repoSalones.findById(id).orElse(null);
	}
	
	public void borrarCurso(Long id) {
		repoSalones.deleteById(id);
	}
	
	public Salon guardarCurso(Salon nuevoCurso) {
		return repoSalones.save(nuevoCurso);
	}
}

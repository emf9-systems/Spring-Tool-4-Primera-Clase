package com.example.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.models.Hobby;
import com.example.app.models.Salon;
import com.example.app.models.Usuario;
import com.example.app.repositories.RepositorioHobbies;
import com.example.app.repositories.RepositorioSalones;
import com.example.app.repositories.RepositorioUsuarios;

import jakarta.transaction.Transactional;

@Service
public class Servicios {
	
	@Autowired
	private RepositorioUsuarios repoUsuarios;
	
	@Autowired
	private RepositorioSalones repoSalones;
	
	@Autowired
	private RepositorioHobbies repoHobbies;

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

	public List<Salon> todosLosSalones() {
		List<Salon> salones = repoSalones.findAll();
		for (Salon salon : salones) {
			salon.getUsuarios().size(); //esto fuerza la carga de los usuarios
		}
		return salones;
	}
	
	public Salon buscarSalon(Long id) {
		return repoSalones.findById(id).orElse(null);
	}
	
	@Transactional
	public void borrarCurso(Long id) {
	    // Set salon_id to NULL for associated users before deleting the salon
	    repoUsuarios.updateSalonIdToNull(id);

	    // Now delete the salon
	    repoSalones.deleteById(id);
	}
	
	public Salon guardarCurso(Salon nuevoCurso) {
		return repoSalones.save(nuevoCurso);
	}
	
	public List<Hobby> todosHobbies(){
		List<Hobby> hobbies = repoHobbies.findAll();
		for (Hobby hobby : hobbies) {
			hobby.getUsuarios().size(); //esto fuerza la carga de los usuarios
		}
		return hobbies;
	}
	
	public Hobby buscarHobby(Long id) {
		return repoHobbies.findById(id).orElse(null);
	}
	
	// Método que asigne un hobby a un usuario
	public void asignarHobbyAUsuario(Long usuarioId, Long hobbyId) {
	    // Obtener el objeto usuario al que le agregamos el hobby
	    Usuario miUsuario = buscarUsuario(usuarioId);

	    // Obtener el objeto hobby que le asignamos
	    Hobby miHobby = buscarHobby(hobbyId);

	    miUsuario.getHobbies().add(miHobby);
	    repoUsuarios.save(miUsuario);
	    
	    //
	}

}

package com.example.app.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.app.models.Hobby;
import com.example.app.models.Salon;
import com.example.app.models.Usuario;
import com.example.app.services.Servicios;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller //Encargado de decir que mi archivo es un controlador. Regresa un .jsp
public class ControllerUsers {
	
	@Autowired
	private Servicios service;
	
	@GetMapping("/index")
	public String index(Model model) {

	    model.addAttribute("titulo", "Estamos integrando Model model");

	    String usuarios[] = {"Elena de Troya", "Juana de Arco", "Pablo Picasso", "Pedro Paramo"};
	    
	   	model.addAttribute("users", usuarios);
	   	
	   	return "index.jsp";
	    
	}
	
	@GetMapping("/form")
	public String formulario() {
	   	return "formulario.jsp";
	}
	
	@PostMapping("/registrarUsuario")
	public String registrar(@RequestParam(value="nombreUsuario") String nombre,
							@RequestParam(value="emailUsuario") String email,
							HttpSession session,
							RedirectAttributes flash) {
		System.out.println("nombre: "+nombre);
		System.out.println("email: "+email);
		
		// Validar la info
		if(nombre.equals("") || email.equals("")) {
		    flash.addFlashAttribute("error", "Todos los datos son obligatorios");
		    return "redirect:/form";
		}
		
		session.setAttribute("name", nombre);
		session.setAttribute("email", email);
		
		return "redirect:/bienvenida";
	}
	
	@GetMapping("/bienvenida")
	public String bienvenida() {
	   	return "bienvenida.jsp";
	}
	
	@GetMapping("/dashboard")
	public String dashboard(Model model) {
		List<Usuario> usuarios = service.todosUsuarios();
		model.addAttribute("usuarios", usuarios);
		List<Salon> salones = service.todosLosSalones();
		model.addAttribute("salones", salones);
		return "dashboard.jsp";
	}
	
	@GetMapping("/nuevo")
	public String nuevo(@ModelAttribute Usuario usuario,
						Model model) {
		List<Salon> salones = service.todosLosSalones();
		model.addAttribute("salones", salones);
		return "nuevo.jsp";
	}
	
	@PostMapping("/crear")
	public String crear(@Valid @ModelAttribute("usuario") Usuario nuevoUsuario,
						BindingResult result,
						Model model) {
		if(result.hasErrors()) {
			List<Salon> salones = service.todosLosSalones();
			model.addAttribute("salones", salones);
			return "nuevo.jsp";
		} else {
			service.guardarUsuario(nuevoUsuario);
			return "redirect:/dashboard";
		}
	}
	
	@GetMapping("/mostrar/{id}") // localhost:8080/mostrar/1
	public String mostrar(@PathVariable Long id, Model model) {
	    Usuario esteUsuario = service.buscarUsuario(id); // buscarUsuario(1)
	    model.addAttribute("usuario", esteUsuario);
	    return "mostrar.jsp";
	}
	
	@DeleteMapping("/borrar/{id}")
	public String borrar(@PathVariable Long id) {
		service.borrarUsuario(id);
	    return "redirect:/dashboard";
	}
	
	//PARA FORMULARIOSSSS OJOOOO AL PATRON QUE SE REPITENNN 
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable Long id,
						 @ModelAttribute Usuario usuario,
						 Model model) {
		Usuario esteUsuario = service.buscarUsuario(id);
		model.addAttribute("usuario", esteUsuario);
		List<Salon> salones = service.todosLosSalones();
		model.addAttribute("salones", salones);
		return "editar.jsp";
	}
	
	@PutMapping("/actualizar/{id}")
	public String actualizar(@Valid @ModelAttribute Usuario usuario,
						     BindingResult result,
						     Model model) {
		if(result.hasErrors()) {
			List<Salon> salones = service.todosLosSalones();
			model.addAttribute("salones", salones);
			return "editar.jsp";
		} else {
			service.guardarUsuario(usuario);
			return "loading.jsp";
		}
	}
	
	@GetMapping("/loading")
	public String pantallaCarga() {
	    return "redirect:/dashboard";
	}
	
	@DeleteMapping("/borrarCursos/{id}")
	public String borrarCurso(@PathVariable Long id) {
		service.borrarCurso(id);
	    return "redirect:/dashboard";
	}
	
	
	@GetMapping("/nuevoCurso")
	public String nuevoCurso(@ModelAttribute Salon salon) {
		return "nuevoCurso.jsp";
	}
	
	@PostMapping("/crearCurso")
	public String crearCurso(@Valid @ModelAttribute("salon") Salon nuevoSalon,
						BindingResult result,
						Model model) {
		if(result.hasErrors()) {
			return "nuevoCurso.jsp";
		} else {
			service.guardarCurso(nuevoSalon);
			return "redirect:/dashboard";
		}
	}
	
	@GetMapping("/mostrarCurso/{id}") // localhost:8080/mostrar/1
	public String mostrarCurso(@PathVariable Long id, Model model) {
	    Salon esteCurso = service.buscarSalon(id); // buscarUsuario(1)
	    model.addAttribute("salon", esteCurso);
	    return "mostrarCurso.jsp";
	}
	
	@GetMapping("/asignar/{id}")
	public String asignar(@PathVariable Long id,
	                      Model model) {
	    // Buscar el usuario al cual le asigno los hobbies
	    Usuario esteUsuario = service.buscarUsuario(id);
	    model.addAttribute("usuario", esteUsuario);

	    // Lista de hobbies
	    List<Hobby> hobbies = service.todosHobbies();
	    model.addAttribute("hobbies", hobbies);

	    return "asignar.jsp";
	}
	
	@GetMapping("/asignarHobby/{usuarioId}/{hobbyId}")
	public String asignarHobby(@PathVariable("usuarioId") Long usuarioId,
	                           @PathVariable("hobbyId") Long hobbyId) {

	    // Invocar a un método que me asigne el hobby a un usuario
		service.asignarHobbyAUsuario(usuarioId, hobbyId);

	    return "redirect:/dashboard";
	}


	

}

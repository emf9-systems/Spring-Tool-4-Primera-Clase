package com.example.app.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
		return "dashboard.jsp";
	}
	
	@GetMapping("/nuevo")
	public String nuevo(@ModelAttribute("usuario") Usuario usuario) {
		return "nuevo.jsp";
	}
	
	@PostMapping("/crear")
	public String crear(@Valid @ModelAttribute("usuario") Usuario nuevoUsuario,
						BindingResult result) {
		if(result.hasErrors()) {
			return "nuevo.jsp";
		} else {
			service.guardarUsuario(nuevoUsuario);
			return "redirect:/dashboard";
		}
	}
	
	@GetMapping("/mostrar/{id}") // localhost:8080/mostrar/1
	public String mostrar(@PathVariable("id") Long id, /* id = 1 */ Model model) {
	    Usuario esteUsuario = service.buscarUsuario(id); // buscarUsuario(1)
	    model.addAttribute("usuario", esteUsuario);
	    return "mostrar.jsp";
	}

}

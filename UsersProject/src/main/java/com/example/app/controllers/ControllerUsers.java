package com.example.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;

@Controller //Encargado de decir que mi archivo es un controlador. Regresa un .jsp
public class ControllerUsers {
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
}

package com.example.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //Encargado de decir que mi archivo es un controlador. Regresa un .jsp
public class ControllerUsers {
	@GetMapping("/index")
	public String index(Model model) {

	    model.addAttribute("titulo", "Estamos integrando Model model");

	    String usuarios[] = {"Elena de Troya", "Juana de Arco", "Pablo Picasso", "Pedro Paramo"};
	    
	   	model.addAttribute("users", usuarios);
	   	
	   	return "index.jsp";
	    
	}

}

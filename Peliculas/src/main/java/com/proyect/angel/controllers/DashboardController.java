package com.proyect.angel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.proyect.angel.services.MoviesServices;

import jakarta.servlet.http.HttpSession;

@Controller
public class DashboardController {
	
	@Autowired
	private MoviesServices mServices;
	
	@GetMapping("/dashboard")
	public String dashboard(HttpSession session) {
		if(session.getAttribute("currentUser")==null) {
			return "redirect:/";
		}
		
		return "/dashboard.jsp";
	}
	
}


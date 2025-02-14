package com.proyect.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class DashboardController {
	@GetMapping("/dashboard")
	public String dashboard(HttpSession session) {
		if(session.getAttribute("currentUser")==null) {
			return "redirect:/";
		}
		
		return "/dashboard.jsp";
	}
	
}

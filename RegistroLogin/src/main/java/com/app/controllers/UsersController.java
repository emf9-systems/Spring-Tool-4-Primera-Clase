package com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.models.LoginUsuario;
import com.app.models.User;
import com.app.services.UsersServices;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UsersController {
	@Autowired
	private UsersServices userServices;
	
	@GetMapping("/")
	public String index(@ModelAttribute("newUser") User newUser,
						@ModelAttribute("loginUsuario") LoginUsuario loginUsuario) {
		return "index.jsp";
	}
	
	@PostMapping("/registro")
	public String registro(@Valid @ModelAttribute("newUser") User newUser,
						   BindingResult result,
						   Model model,
						   HttpSession session) {
		userServices.registrar(newUser, result);
		if(result.hasErrors()) {
			model.addAttribute("loginUsuario", new LoginUsuario());
			return "index.jsp";
		} else {
			session.setAttribute("onSession", newUser);
			return "redirect:/dashboard";
		}
	}
	
	@GetMapping("/dashboard")
	public String dashboard(HttpSession session) {
		if(session.getAttribute("onSession")==null) {
			return "redirect:/";
		} else {
			return "dashboard.jsp";
		}
	}
	
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("loginUsuario") LoginUsuario loginUsuario,
						BindingResult result,
						Model model,
						HttpSession session) {
		
		User loginTry = userServices.login(loginUsuario, result);
		if(result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "index.jsp";
		} else {
			session.setAttribute("onSession", loginTry);
			return "redirect:/dashboard";
		}
		
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
	    session.invalidate(); // Cierra la sesión
	    return "redirect:/";  // Redirige al inicio
	}

}

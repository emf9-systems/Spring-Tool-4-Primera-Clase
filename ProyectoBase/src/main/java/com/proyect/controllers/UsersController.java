package com.proyect.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.proyect.models.User;
import com.proyect.models.UserLogin;
import com.proyect.services.UsersServices;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UsersController {
	@Autowired
	private UsersServices uServices;
	
	@GetMapping("/")
	public String index(@ModelAttribute("newUser") User newUser) {
		return "index.jsp";
	}
	
	@PostMapping("/registro")
	public String signIn(@Valid @ModelAttribute("newUser") User newUser,
						 BindingResult result,
						 HttpSession session) {
		uServices.register(newUser, result);
		if(result.hasErrors()) {
			return "index.jsp";
		} else {
			session.setAttribute("onSession", newUser);
			return "redirect:/dashboard";
		}
		
	}
	
	@GetMapping("/login")
	public String login(@ModelAttribute("userLogin") UserLogin userLogin) {
		return "login.jsp";
	}
	
	@PostMapping("/logIn")
	public String logIn(@Valid @ModelAttribute("userLogin") UserLogin userLogin,
						BindingResult result,
						HttpSession session) {
		User user = uServices.login(userLogin, result);
		if(result.hasErrors()) {
			return "login.jsp";
		} else {
			session.setAttribute("onSession", user);
			return "redirect:/dashboard";
		}
		
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
}

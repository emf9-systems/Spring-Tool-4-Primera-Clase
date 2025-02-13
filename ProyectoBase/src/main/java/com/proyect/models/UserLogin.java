package com.proyect.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UserLogin {
	
	@NotBlank(message="Este campo es obligatorio")
	@Email(message="Ingrese un Email valido")
	private String emailLogin;
	@NotBlank(message="Este campo es obligatorio")
	private String passwordLogin;
	
	public UserLogin() {}

	public String getEmailLogin() {
		return emailLogin;
	}

	public void setEmailLogin(String emailLogin) {
		this.emailLogin = emailLogin;
	}

	public String getPasswordLogin() {
		return passwordLogin;
	}

	public void setPasswordLogin(String passwordLogin) {
		this.passwordLogin = passwordLogin;
	}


}

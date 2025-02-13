package com.app.services;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.app.models.LoginUsuario;
import com.app.models.User;
import com.app.repository.UsersRepository;

@Service
public class UsersServices {
	
	@Autowired
	private UsersRepository usersRepo;
	
	public User registrar(User newUser, BindingResult result) {
		
		String password = newUser.getPassword();
		String passwordConfirmation = newUser.getPasswordConfirmation();
		if(!password.equals(passwordConfirmation)) {
			result.rejectValue("passwordConfirmation", "Matches", "La contraseña no coincide");
		}
		
		String email = newUser.getEmail();
		User existingUser = usersRepo.findByEmail(email);
		if(existingUser != null) {
			result.rejectValue("email", "Unique", "El correo que esta intentando ingresar ya se encuentra registrado");
		}
		
		if(result.hasErrors()) {
			return null;
		} else {
			//Encriptar password
			String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
			newUser.setPassword(hashedPassword);
			return usersRepo.save(newUser);
		}
	}
	
	public User login(LoginUsuario loginUsuario,
					  BindingResult result) {
		
		String email = loginUsuario.getEmailLogin();
		User userExists = usersRepo.findByEmail(email);
		
		if(userExists==null) {
			result.rejectValue("emailLogin", "Unique", "Email no registrado");
		} else if(!BCrypt.checkpw(loginUsuario.getPasswordLogin(), userExists.getPassword())) {
			result.rejectValue("passwordLogin", "Matches", "La contraseña es incorrecta");
		}
		
		if(result.hasErrors()) {
			return null;
		} else {
			return userExists;
		}
	}
	
}

package com.proyect.angel.services;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.proyect.angel.models.User;
import com.proyect.angel.models.UserLogin;
import com.proyect.angel.repositories.UsersRepository;

@Service
public class UsersServices {
	@Autowired
	private UsersRepository usersRepo;

	public User register(User newUser,
						 BindingResult result) {
		
		String password = newUser.getPassword();
		String confirmation = newUser.getPasswordConfirmation();
		if(!password.equals(confirmation)) {
			result.rejectValue("password", "Matches", "Las contraseñas no coinciden");
		}
		
		String email = newUser.getEmail();
		User userExists = usersRepo.findByEmail(email);
		if(userExists!=null) {
			result.rejectValue("email", "Unique", "Este Email ya se encuentra registrado");
		}
		
		if(result.hasErrors()) {
			return null;
		} else {
			String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
			newUser.setPassword(hashedPassword);
			return usersRepo.save(newUser);
		}
	}
	
	public User login(UserLogin userLogin,
					  BindingResult result) {
		String email = userLogin.getEmailLogin();
		User userExists = usersRepo.findByEmail(email);
		if(userExists==null) {
			result.rejectValue("emailLogin", "Unique", "Email no registrado");
		} else if(!BCrypt.checkpw(userLogin.getPasswordLogin(), userExists.getPassword())) {
			result.rejectValue("passwordLogin", "Matches", "Contraseña o correo incorrecto");
		}
		
		if(result.hasErrors()) {
			return null;
		} else {
			return userExists;
		}
	}
}



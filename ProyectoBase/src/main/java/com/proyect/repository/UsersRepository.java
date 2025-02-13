package com.proyect.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.proyect.models.User;

@Repository
public interface UsersRepository extends CrudRepository<User, Long> {
	
	User findByEmail(String email);
	
}

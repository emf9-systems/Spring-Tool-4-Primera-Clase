package com.proyect.angel.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.proyect.angel.models.User;

@Repository
public interface UsersRepository extends CrudRepository<User, Long> {
	User findByEmail(String email);
}

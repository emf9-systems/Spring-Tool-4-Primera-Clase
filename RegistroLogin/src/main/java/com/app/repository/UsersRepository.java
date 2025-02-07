package com.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.models.User;

@Repository
public interface UsersRepository extends CrudRepository<User, Long>{
	
	User findByEmail(String email);

}

package com.example.app.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.app.models.Hobby;

@Repository
public interface RepositorioHobbies extends CrudRepository<Hobby, Long>{
	List<Hobby> findAll();
}

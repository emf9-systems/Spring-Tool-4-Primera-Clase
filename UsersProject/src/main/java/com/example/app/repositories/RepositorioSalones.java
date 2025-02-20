package com.example.app.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.app.models.Salon;

@Repository
public interface RepositorioSalones extends CrudRepository<Salon, Long>{
	List<Salon> findAll();

}

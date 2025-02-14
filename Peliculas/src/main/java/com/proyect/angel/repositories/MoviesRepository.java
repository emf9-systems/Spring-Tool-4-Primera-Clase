package com.proyect.angel.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.proyect.angel.models.Movie;

@Repository
public interface MoviesRepository extends CrudRepository<Movie, Long> {
	List<Movie> findAll();
	List<Movie> findAllByOrderByTitleAsc();
	List<Movie> findAllByOrderByReleaseYearAsc();
	List<Movie> findAllByOrderByReleaseYearDesc();
	List<Movie> findByTitleContaining(String word);

}

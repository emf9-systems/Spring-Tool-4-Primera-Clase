package com.proyect.angel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyect.angel.models.Movie;
import com.proyect.angel.repositories.MoviesRepository;
import com.proyect.angel.repositories.UsersRepository;

@Service
public class MoviesServices {
	@Autowired
	private UsersRepository usersRepo;
	@Autowired
	private MoviesRepository moviesRepo;
	
	public List<Movie> allMovies() {
		return moviesRepo.findAll();
	}
	
	public Movie saveMovie(Movie movie) {
		return moviesRepo.save(movie);
	}
	
	public Movie searchMovie(Long id) {
		return moviesRepo.findById(id).orElse(null);
	}
	
	public void deleteMovie(Long id) {
		moviesRepo.deleteById(id);
	}
}



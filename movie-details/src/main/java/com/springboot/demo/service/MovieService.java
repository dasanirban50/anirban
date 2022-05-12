package com.springboot.demo.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.demo.entity.Movie;
import com.springboot.demo.exception.MovieFoundException;
import com.springboot.demo.exception.MovieNotFoundException;
import com.springboot.demo.repository.MovieRepository;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepository movieRepository;

	public List<Movie> getAllMovies() {
		List<Movie> allMovies = movieRepository.findAll();
		if(allMovies.size() == 0){
			throw new MovieNotFoundException("No Movie is present in database");
		}
		Collections.sort(allMovies, new Comparator<Movie>() {

			@Override
			public int compare(Movie o1, Movie o2) {
				if(o1.getmId() > o2.getmId())
					return 1;
				else if(o1.getmId() < o2.getmId())
					return -1;
				return 0;
			}
		});
		return allMovies;
	}

	public Optional<Movie> getMovieById(int movieId) {
		Optional<Movie> movieById = movieRepository.findById(movieId);
		if(!movieById.isPresent())
			throw new MovieNotFoundException("No Movie is present in database with Movie Id :"+movieId);
		return movieById;
	}

	public Movie createMovie(Movie movie) {
		Optional<Movie> movieById = movieRepository.findById(movie.getmId());
		if(movieById.isPresent()) {
			throw new MovieFoundException("Movie is already present in database with Movie Id :"+movie.getmId());
		}
		Movie savedMovie = movieRepository.save(movie);
		if(savedMovie == null) {
			
		}
		return savedMovie;
	}

	public Movie updateMovie(Movie movie, int movieId) {
		Optional<Movie> movieById = movieRepository.findById(movieId);
		if(!movieById.isPresent()) {
			throw new MovieNotFoundException("No Movie is present in database with Movie Id :"+movieId);
		}
		movie.setmId(movieId);
		Movie updateMovie = movieRepository.save(movie);
		if(updateMovie == null) {
			
		}
		return updateMovie;
	}

	public Optional<Movie> deleteMovieById(int movieId) {
		Optional<Movie> movieById = movieRepository.findById(movieId);
		if(!movieById.isPresent()) {
			throw new MovieNotFoundException("No Movie is present in database with Movie Id :"+movieId);
		}
		movieRepository.deleteById(movieId);
		return movieById;
	}
}

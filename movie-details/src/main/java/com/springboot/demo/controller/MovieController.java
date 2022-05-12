package com.springboot.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.demo.entity.Movie;
import com.springboot.demo.service.MovieService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/rest/movie")
@Api(value = "MovieController", tags = "Movie Management RESTful Services")
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	@GetMapping()
	@ApiOperation(value = "Return all Movies")
	public ResponseEntity<List<Movie>> getAllMovies(){
		List<Movie> allMovies = movieService.getAllMovies();
		return ResponseEntity.status(HttpStatus.OK).body(allMovies);
	}
	
	@GetMapping("/{movieId}")
	@ApiOperation(value = "Return Movie by Id")
	public ResponseEntity<Movie> getMovieById(@ApiParam(value = "Movie Id for fetching the Movie details") 
	@PathVariable("movieId") int movieId){
		Optional<Movie> movieById = movieService.getMovieById(movieId);
		return ResponseEntity.status(HttpStatus.OK).body(movieById.get());
	}
	
	@PostMapping("")
	@ApiOperation(value = "Create a new Movie")
	public ResponseEntity<Movie> createMovie(@ApiParam(value = "Movie information to create a new Movie") 
	@Valid @RequestBody Movie movie){
		Movie savedMovie = movieService.createMovie(movie);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedMovie);
	}
	
	@PutMapping("")
	@ApiOperation(value = "Update an exisitng Movie")
	public ResponseEntity<Movie> updateMovie(@ApiParam(value = "Movie information to update a existing Movie") 
	@Valid @RequestBody Movie movie,@ApiParam(value = "Movie Id for updating the Movie details") 
	@PathParam("movieId") int movieId){
		Movie savedMovie = movieService.updateMovie(movie,movieId);
		return ResponseEntity.status(HttpStatus.OK).body(savedMovie);
	}
	
	@DeleteMapping("/{movieId}")
	@ApiOperation(value = "Delete an exisitng Movie")
	public ResponseEntity<Optional<Movie>> deleteMovieById(@ApiParam(value = "Movie Id for deleting the Movie details") 
	@PathVariable("movieId") int movieId){
		Optional<Movie> deleteMovieById = movieService.deleteMovieById(movieId);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(deleteMovieById);
	}
}

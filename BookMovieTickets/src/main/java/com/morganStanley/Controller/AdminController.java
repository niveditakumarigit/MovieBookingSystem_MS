package com.morganStanley.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.morganStanley.ServiceImp.MovieServiceImpl;
import com.morganStanley.model.Movie;

@RestController
public class AdminController {

@Autowired MovieServiceImpl movieService;
	
	@PostMapping("/addMovies")
	public ResponseEntity<List<Movie>> addShow(@RequestBody List<Movie> movie){
		return new ResponseEntity<List<Movie>>(movieService.addMovie(movie), HttpStatus.CREATED);
	}
	
	//TODO
		//add method for delete and update movies
		
	
	
	
	
	
	
	/*
	 * public void createMovie() {
	 * 
	 * // Create Movies Movie pk = new Movie(); pk.setMovieId(1);
	 * pk.setMovieName("PK"); pk.setCity("Bangalore"); //pk.addMovie(pk );
	 * 
	 * Movie dark = new Movie(); dark.setMovieId(23); dark.setMovieName("Dark");
	 * dark.setCity("Bangalore"); //dark.addMovie(dark);
	 * 
	 * Movie drishyam = new Movie(); drishyam.setMovieId(44);
	 * drishyam.setMovieName("Drishyam"); drishyam.setCity("Bangalore");
	 * //drishyam.addMovie(drishyam);
	 * 
	 * Movie hero = new Movie(); hero.setMovieId(4); hero.setMovieName("Dangal");
	 * hero.setCity("Delhi"); //hero.addMovie(hero);
	 * 
	 * Movie hero2 = new Movie(); hero2.setMovieId(43); hero2.setMovieName("Her0");
	 * hero2.setCity("Hyderabad"); //hero.addMovie(hero2);
	 * 
	 * MovieServiceImpl movie = new MovieServiceImpl(); movie.addMovie(hero2);
	 * movie.addMovie(dark); movie.addMovie(drishyam); movie.addMovie(hero);
	 * movie.addMovie(pk);
	 * 
	 * }
	 */


	// TODO 
	//public void editMovie() {} 

	//public void deleteMovie() {}

	

}

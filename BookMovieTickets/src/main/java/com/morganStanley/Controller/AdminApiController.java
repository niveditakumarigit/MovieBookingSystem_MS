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
public class AdminApiController {

@Autowired MovieServiceImpl movieService;
	
	@PostMapping("/addMovies")
	public ResponseEntity<List<Movie>> addShow(@RequestBody List<Movie> movie){
		return new ResponseEntity<List<Movie>>(movieService.addMovie(movie), HttpStatus.CREATED);
	}


}

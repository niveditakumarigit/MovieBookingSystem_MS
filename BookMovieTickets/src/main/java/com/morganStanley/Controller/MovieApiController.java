package com.morganStanley.Controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.morganStanley.ServiceImp.MovieServiceImpl;
import com.morganStanley.model.Movie;

@RestController

public class MovieApiController {

	@Autowired
	MovieServiceImpl movieService;

	@GetMapping("/getAllCities")
	public ResponseEntity<Set<String>> getAllCities() {
		return new ResponseEntity<Set<String>>(movieService.getAllCities(), HttpStatus.OK);
	}
	
	@GetMapping("/getAllMovies")
	public ResponseEntity<List<Movie>> geAllMovies() {
		return new ResponseEntity<List<Movie>>(movieService.getAllMovies(), HttpStatus.OK);
	}

	@GetMapping("city/{cityName}/movies")
	public ResponseEntity<List<Movie>> getAllMovieByCity(@PathVariable String cityName) {
		return new ResponseEntity<List<Movie>>(movieService.getAllMovieByCity(cityName), HttpStatus.OK);
	}

	@GetMapping("/getAvailableSeats")
	public ResponseEntity<List<SeatStatus>> getAvailableSeats(@RequestParam ("movieId") int movieId, @RequestParam ("theatreId") int theatreId, @RequestParam ("showId") int showId) {
		return new ResponseEntity<List<SeatStatus>>(movieService.getAvailableSeats(movieId, theatreId, showId), HttpStatus.OK);
	}


}

package com.morganStanley.Controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.morganStanley.ServiceImp.MovieServiceImpl;
import com.morganStanley.model.Movie;

@RestController
//@RequestMapping("/bookMovieTicket")

public class MovieApiController {

	@Autowired
	MovieServiceImpl movieService;

	@GetMapping("/getAllMovies")
	public ResponseEntity<List<Movie>> geAllMovies() {
		return new ResponseEntity<List<Movie>>(movieService.getAllMovies(), HttpStatus.OK);
	}

	@GetMapping("city/{cityName}/movies")
	public ResponseEntity<List<String>> getAllMovieByCity(@PathVariable String cityName) {
		return new ResponseEntity<List<String>>(movieService.getAllMovieByCity(cityName), HttpStatus.OK);
	}
	
	@GetMapping("/allCities")
	public ResponseEntity<Set<String>> getAllCities(){
		return new ResponseEntity<Set<String>>(movieService.getAllCities(), HttpStatus.OK);
	}
	

//	@GetMapping("/allCities")
//	public ResponseEntity<Object> getAllCities() {
//		Map<String, List<Movie>> moviesList = MovieServiceImpl.getAllCities();
//		List<String> cities = moviesList.entrySet().stream().map(s -> s.getKey()).collect(Collectors.toList());
//
//		CityInfo cityInfo = new CityInfo();
//
//		cityInfo.cityList = cities;
//
//		return new ResponseEntity<Object>(cityInfo, HttpStatus.OK);
//
//	}
//
//	@GetMapping("/city/{cityName}/movies")
//	public ResponseEntity<List<Movie>> getMoviesListByCity(@PathVariable String cityName) {
//		List<Movie> movieobj = MovieServiceImpl.getMoviesByCity(cityName);
//		System.out.println(movieobj);
//		
//				
//		return new ResponseEntity<>(movieobj, HttpStatus.OK);
//		
//	
//	}
	
//	@GetMapping("/allMovies")
//	public ResponseEntity<Set<Movie>> getMoviesList() {
//		Set<Movie> movies =  MovieServiceImpl.getAllMovies();
//		System.out.println(movies);
//		
//				
//		return new ResponseEntity<>(movies, HttpStatus.OK);
//		
//	
//	}

	
	
}

package com.morganStanley.ServiceImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.morganStanley.model.Movie;
import com.morganStanley.repository.MovieRepository;

@Service
public class MovieServiceImpl  {

	@Autowired
	MovieRepository movieRepo;

	public List<Movie> addMovie(List<Movie> movie) {
		movieRepo.saveAll(movie);
		return movie;

	}

	public List<Movie> getAllMovies() {

		List<Movie> allMovies = new ArrayList<>();
		movieRepo.findAll().forEach(s -> allMovies.add(s));
		return allMovies;

	}
	
	public Set<String> getAllCities() {
		
		List<Movie> allMovies = new ArrayList<>();
		movieRepo.findAll().forEach(s -> allMovies.add(s));
		Set<String> cities = allMovies.stream().map(s-> s.getCity()).collect(Collectors.toSet());
		return cities;

	}
	
	public List<String> getAllMovieByCity(String cityName) {

		List<Movie> allMovies = new ArrayList<>();
		
		movieRepo.findAll().forEach(s -> allMovies.add(s));
		List<String> cities = allMovies.stream().filter(x-> x.getCity().equals(cityName)).map(s-> s.getCity()).collect(Collectors.toList());
		return cities;

	}
	
	
	
	
//	
//	private static Map<String, List<Movie>> movieInCityMap = new HashMap<>();
//	
//	List<Movie> moviesList = new ArrayList<>();
	
	
	/*
	 * //Add movie to a particular city
	 * 
	 */
//	public void addMovies(Movie movies) {
//
//		// List<Movie> addMovies = new ArrayList<>();
//		// addMovies.add(movies);
//		ArrayList tempList = null;
//		if (movieInCityMap.containsKey(movies.getCity())) {
//			tempList = (ArrayList) movieInCityMap.get(movies.getCity());
//
//			//tempList.add(addMovies);
//			tempList.add(movies);
//		} else {
//			tempList = new ArrayList();
//			//tempList.add(addMovies);
//			tempList.add(movies);
//		}
//		movieInCityMap.put(movies.getCity(), tempList);
//	}
//
//	/* Return list of movies based on city */
//	public static List<Movie> getMoviesByCity(String city) {
//		return movieInCityMap.get(city);
//	}
//
//	/* Return list of all movies */
//	public static Map<String, List<Movie>> getAllCities() {
//		
//		return movieInCityMap;
//
//	}
//	
//
//	public static Set<Movie> getAllMovies() {
//		Set<List<Movie>> movieList =  movieInCityMap.entrySet().stream().map(a-> a.getValue()).collect(Collectors.toSet());
//		Set<Movie> flattenedList = movieList.stream().flatMap(List::stream).collect(Collectors.toSet());
//		//Map<Integer, String > map = flattenedList.stream().collect(Collectors.toMap(s->s.getMovieId(), s->s.getMovieName()));
//		//Set<String> names = flattenedList.stream().map(s-> s.getMovieName()).collect(Collectors.toSet());
//		System.out.println(flattenedList);
//	
//		
//		return flattenedList;
//	}
//	
	
	

	// If required
	// public void editMovie();

	// public void deleteMovie();

}

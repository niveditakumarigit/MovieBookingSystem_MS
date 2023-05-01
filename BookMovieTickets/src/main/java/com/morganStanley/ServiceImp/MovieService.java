package com.morganStanley.ServiceImp;

import java.util.List;
import java.util.Map;

import com.morganStanley.model.Movie;

public interface MovieService {
	
	
	
	/*
	 * //Add movie to a particular city
	 * 
	 */   
	public void addMovie(Movie movies); 
		
	

	/* Return list of movies based on city */
	public static  List<Movie> getMoviesByCity(String city){
		return null;
	}
	
	/* Return list of all movies  */
	public static Map<String, List<Movie>> getAllMoviesList() {
		return null;
	}
	
	//public void editMovie(); 

	//public void deleteMovie();



}

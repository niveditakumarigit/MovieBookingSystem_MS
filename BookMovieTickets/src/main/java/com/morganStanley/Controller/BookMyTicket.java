package com.morganStanley.Controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.morganStanley.ServiceImp.MovieServiceImpl;
import com.morganStanley.model.Movie;

public class BookMyTicket {
	
	
	public static void main(String args[]) {

		BookMyTicket bookMyTicket = new BookMyTicket();
		

		bookMyTicket.initialize();
		
		  //1. search movie by  city
		MovieServiceImpl movie = new MovieServiceImpl();
        //List<Movie> movies1 = movie.getMoviesByCity("Bangalore");
        //List<Movie> movies2 = movie.getMoviesByCity("Delhi");
        
        
        
        //Map<String, List<Movie>> moviesList = MovieServiceImpl.getAllMovies();
        
        System.out.println("***************");
        //System.out.println("Movie list by  " + moviesList.entrySet());
        
//       
//        
//       List<Movie> movie2 = MovieServiceImpl.getMoviesByCity("Bangalore");
//        System.out.println("***************");
//        System.out.println(movie2);
//        
//        Set<Movie> movie23 = MovieServiceImpl.getAllMovies();
//        
//        System.out.println(movie23);
//      
//       System.out.println(movie2);
//      
//     

    }
	
	private void initialize() {
		AdminController admin = new AdminController();
		//admin.createMovie();
	}



}

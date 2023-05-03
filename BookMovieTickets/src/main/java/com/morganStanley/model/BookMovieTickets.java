package com.morganStanley.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class BookMovieTickets {
	private int movieId; 
	private String city; 
	private int showId; 
	private int theatreId; 
	private LocalDate date;
	private LocalTime movieTiming; 
	private List<Integer> seatsToBook;
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getShowId() {
		return showId;
	}
	public void setShowId(int showId) {
		this.showId = showId;
	}
	public int getTheatreId() {
		return theatreId;
	}
	public void setTheatreId(int theatreId) {
		this.theatreId = theatreId;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public LocalTime getMovieTiming() {
		return movieTiming;
	}
	public void setMovieTiming(LocalTime movieTiming) {
		this.movieTiming = movieTiming;
	}
	public List<Integer> getSeatsToBook() {
		return seatsToBook;
	}
	public void setSeatsToBook(List<Integer> seatsToBook) {
		this.seatsToBook = seatsToBook;
	}
	
	
}

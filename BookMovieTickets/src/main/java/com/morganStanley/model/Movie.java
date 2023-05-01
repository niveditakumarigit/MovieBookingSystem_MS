package com.morganStanley.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Movie {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int movieId;
	@Column
	private String movieName;
	@Column
	private int movieDuration;
	@Column
	private String city;
	
	
	public int getMovieId() {
		return movieId;
	}


	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}


	public String getMovieName() {
		return movieName;
	}


	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}


	public int getMovieDuration() {
		return movieDuration;
	}


	public void setMovieDuration(int movieDuration) {
		this.movieDuration = movieDuration;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", movieDuration=" + movieDuration
				+  "city=" + city + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(city, movieDuration, movieId, movieName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		return Objects.equals(city, other.city) 
				&& movieDuration == other.movieDuration && movieId == other.movieId
				&& Objects.equals(movieName, other.movieName);
	}

	
	

}

package com.morganStanley.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Show {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int showId;
	
	@Column
	private LocalDate date;
	@Column
	private LocalTime movieStartTiming;
	@Column
	private LocalTime movieEndTiming;
	@Column
	private int totalSeats;
	@ElementCollection
	private boolean[] seatAvailability;
	
	
	@ManyToOne
    @JoinColumn(name = "THEATRE_ID")
    private Theatre theatre;	
	
	
	public Show() {
		super();
		if(totalSeats > 0)
		{
			this.seatAvailability = new boolean[totalSeats];
		}		
	}
	
	public int getShowId() {
		return showId;
	}
	public void setMovieStartTiming(LocalTime movieStartTiming) {
		this.movieStartTiming = movieStartTiming;
	}
	public void setMovieEndTiming(LocalTime movieEndTiming) {
		this.movieEndTiming = movieEndTiming;
	}
	
	public void setShowId(int showId) {
		this.showId = showId;
	}
	
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	@Override
	public int hashCode() {
		return Objects.hash(date, movieEndTiming, movieStartTiming, showId, theatre);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Show other = (Show) obj;
		return Objects.equals(date, other.date) && Objects.equals(movieEndTiming, other.movieEndTiming)
				&& Objects.equals(movieStartTiming, other.movieStartTiming)
				&& showId == other.showId
				&& Objects.equals(theatre, other.theatre);
	}
	

}

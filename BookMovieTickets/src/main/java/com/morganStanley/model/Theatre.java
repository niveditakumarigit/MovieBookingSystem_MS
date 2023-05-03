package com.morganStanley.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Theatre {
	
	@Id
	@Column(name = "theatre_Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int theatreId;
	@Column
	private String theatreName;
	@Column
	private String theatreAddress;
	@Column
	private int movieId;
	
	@OneToMany(cascade = CascadeType.MERGE, mappedBy = "theatre")
	private List<Show> show;
	
	public int getTheatreId() {
		return theatreId;
	}
	public void setTheatreId(int theatreId) {
		this.theatreId = theatreId;
	}
	public String getTheatreName() {
		return theatreName;
	}
	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}
	public String getTheatreAddress() {
		return theatreAddress;
	}
	public void setTheatreAddress(String theatreAddress) {
		this.theatreAddress = theatreAddress;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	
	public List<Show> getShow() {
		return show;
	}
	public void setShow(List<Show> show) {
		this.show = show;
	}
	
	
	

	

}

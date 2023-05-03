package com.morganStanley.ServiceImp;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.morganStanley.ExceptionHandler.NotFoundException;
import com.morganStanley.model.BookMovieTickets;
import com.morganStanley.model.Movie;
import com.morganStanley.model.Show;
import com.morganStanley.model.Theatre;
import com.morganStanley.repository.MovieRepository;
import com.morganStanley.repository.SeatStatus;
import com.morganStanley.repository.ShowRepository;

@Service
public class MovieServiceImpl {

	@Autowired
	MovieRepository movieRepo;
	@Autowired
	ShowRepository showRepo;
	@Autowired
	TheatreServiceImpl theatreService;

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
		Set<String> cities = allMovies.stream().map(s -> s.getCity()).collect(Collectors.toSet());
		return cities;

	}

	public List<Movie> getAllMovieByCity(String cityName) {

		List<Movie> allMovies = new ArrayList<>();

		movieRepo.findAll().forEach(s -> allMovies.add(s));
		List<Movie> movieList = allMovies.stream().filter(x -> x.getCity().equals(cityName))
				.collect(Collectors.toList());
		return movieList;
	}

	public List<SeatStatus> getAvailableSeats(int movieId, int theatreId, int showId) {

		List<Theatre> theatreDetails = theatreService.getAllTheatres().stream().filter(s -> s.getMovieId() == movieId)
				.filter(s -> s.getTheatreId() == theatreId).toList();

		if (theatreDetails.isEmpty()) {
			// Error, return
			throw new NotFoundException("Not valid theatre Id or movie Id");
		}

		List<Show> showDetails = theatreService.getShow().stream().filter(s -> s.getShowId() == showId).toList();

		if (showDetails.isEmpty()) {
			// Error, return
			throw new NotFoundException("Not valid show Id");
		}

		boolean[] seatAvailability = showDetails.get(0).getSeatAvailability();
		List<SeatStatus> statusList = new ArrayList<>();
		for (int i = 0; i < seatAvailability.length; i++) {
			SeatStatus status = new SeatStatus();
			status.seatNumber = i + 1;
			status.isAvailable = seatAvailability[i];
			statusList.add(status);
		}
		return statusList;
	}

	public HashMap<String, String> bookMovieTicket(BookMovieTickets bookTickets) {

		int theatreId = bookTickets.getTheatreId();
		int movieId = bookTickets.getMovieId();
		int showId = bookTickets.getShowId();
		LocalDate movieDate = bookTickets.getDate();
		LocalTime movieTiming = bookTickets.getMovieTiming();
		List<Integer> seatToBook = bookTickets.getSeatsToBook();

		HashMap<String, String> map = new HashMap<>();

		List<Theatre> theatreDetails = theatreService.getAllTheatres().stream()
				.filter(x -> x.getTheatreId() == theatreId).filter(x -> x.getMovieId() == movieId).toList();

		if (theatreDetails.isEmpty()) {
			// Error, return
			map.put("error", "Not Valid movieId or theatreId ");
			return map;
		}
		List<Show> showDetails = theatreService.getShow().stream().filter(s -> s.getShowId() == showId).toList();

		if (showDetails.isEmpty()) {
			map.put("error", "Not Valid showId or date or start time ");
			return map;
		}

		Show show = showDetails.get(0);

		int dateComaparison = show.getDate().compareTo(movieDate);
		if (dateComaparison != 0) {
			map.put("error", "Not Valid Date selected ");
			return map;

		}

		int timeComaparison = show.getMovieStartTiming().compareTo(movieTiming);
		if (timeComaparison != 0) {
			map.put("error", "Not Valid time selected ");
			return map;

		}

		boolean[] seatAvailability = show.getSeatAvailability();
		int totalSeats = show.getTotalSeats();
		for (int i : seatToBook) {
			if (i < 1 || i > totalSeats) {

				map.put("error", "Seat to book is greater than total seat or less than 0 ");
				return map;
			}

			if (!seatAvailability[i - 1]) {
				map.put("error", "Seat not available");
				return map;

			}
		}

		// TODO: Check with theater if seat still available
		// Acquire exclusive lock for each seat to be booked
		for (int i : seatToBook) {
			seatAvailability[i - 1] = false;
		}

		showRepo.save(show);
		map.put("success", "Successfully booked tickets");
		return map;
	}

}

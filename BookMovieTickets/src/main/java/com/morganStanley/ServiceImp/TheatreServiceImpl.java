package com.morganStanley.ServiceImp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.morganStanley.ExceptionHandler.NotFoundException;
import com.morganStanley.model.Movie;
import com.morganStanley.model.Show;
import com.morganStanley.model.Theatre;
import com.morganStanley.repository.ShowRepository;
import com.morganStanley.repository.TheatreRepository;

@Service
public class TheatreServiceImpl {

	@Autowired
	ShowRepository showrepo;
	@Autowired
	TheatreRepository theatreRepo;
	@Autowired
	MovieServiceImpl movieService;
	

	public Show addShow(Show show) {
		showrepo.save(show);
		return show;

	}

	public List<Show> getShow() {

		List<Show> allShow = new ArrayList<>();
		showrepo.findAll().forEach(show -> allShow.add(show));
		return allShow;

	}

	public Theatre addTheatre(Theatre theatre) throws NotFoundException {

		List<Movie> movie = movieService.getAllMovies();
		int movieId = theatre.getMovieId();
		List<Integer> validMovieId = movie.stream().filter(id -> id.getMovieId() == movieId).map(x -> x.getMovieId())
				.collect(Collectors.toList());
		if (validMovieId.isEmpty()) {
			throw new NotFoundException("Specified Movie id not found");

		}

		int numberOfshows = theatre.getShow().size();

		for (int i = 0; i < numberOfshows; i++) {
			int totalSeat = theatre.getShow().get(i).getTotalSeats();
			Show show = new Show(totalSeat);
			boolean[] seatAvaialble = show.getSeatAvailability();
			theatre.getShow().get(i).setSeatAvailability(seatAvaialble);
		}

		// adding show
		showrepo.saveAll(theatre.getShow());

		theatreRepo.saveAndFlush(theatre);
		return theatre;
	}

	public List<Theatre> getAllTheatres() {
		List<Theatre> theatres = theatreRepo.findAll();
		
		for (Theatre theatre: theatres)
		{
			for(Show show: theatre.getShow())
			{
				show.getShowId();
			}
		}
		
		return theatres;
	}

}

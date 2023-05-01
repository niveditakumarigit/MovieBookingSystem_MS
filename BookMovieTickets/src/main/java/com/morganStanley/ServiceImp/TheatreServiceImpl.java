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
	
	@Autowired ShowRepository showrepo;
	@Autowired TheatreRepository theatreRepo;
	@Autowired MovieServiceImpl movieService;
	
	public Show addShow(Show show) {
		showrepo.save(show);
		return  show;
		
	}
	
	public List<Show> getShow() {
		
		List<Show> allShow = new ArrayList<>();
		showrepo.findAll().forEach(show -> allShow.add(show));
		return allShow;
		
	}
	
	
	public Theatre addTheatre(Theatre theatre) throws NotFoundException {
		
		List<Movie> movie = movieService.getAllMovies();
		int movieId = theatre.getMovieId();
		List<Integer> validmovieId = movie.stream().filter(id -> id.getMovieId() == movieId)
													.map(x-> x.getMovieId())
													.collect(Collectors.toList());
		if( validmovieId.isEmpty()) {
			throw new NotFoundException("Specified Movie id not found");
			
		}
		
		theatreRepo.save(theatre);
		return theatre;
		
		
	}
	public List<Theatre> getTheatre() {
		
		List<Theatre> allTheatre = new ArrayList<>();
		theatreRepo.findAll().forEach(theatre -> allTheatre.add(theatre));
		return allTheatre;
		
	}


//	private List<Show> showDetails = new ArrayList<>();
//
//	public void addShowTIming(int movieId, int threatreId, LocalTime movieStartTiming, LocalTime movieEndTiming,
//			LocalDate movieDate) {
//
//		Set<Movie> movieList = MovieServiceImpl.getAllMovies();
//		List<Integer> movieIds = movieList.stream().filter(s -> s.getMovieId() == movieId).map(s -> s.getMovieId())
//				.collect(Collectors.toList());
//		if (!movieIds.isEmpty()) {
//			Show show = new Show();
//			Seat seat = new Seat();
//			seat.setTotalSeat(100);
//
//			show.setMovieId(movieId);
//			show.setTheatreId(threatreId);
//			show.setSeats(seat);
//			show.setDate(movieDate);
//			show.setMovieStartTiming(movieStartTiming);
//			show.setMovieEndTiming(movieEndTiming);
//			showDetails.add(show);
//
//		} else {
//			System.out.println("Invalid movie ID");
//		}
//	}
}

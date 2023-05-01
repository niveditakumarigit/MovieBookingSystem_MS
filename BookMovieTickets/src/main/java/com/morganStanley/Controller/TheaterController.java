package com.morganStanley.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.morganStanley.ServiceImp.TheatreServiceImpl;
import com.morganStanley.model.Show;
import com.morganStanley.model.Theatre;

@RestController
public class TheaterController {
	
	@Autowired TheatreServiceImpl threatreService;
	
	
	@PostMapping("/addShow")
	public ResponseEntity<Show> addShow(@RequestBody Show show){
		return new ResponseEntity<Show>(threatreService.addShow(show), HttpStatus.CREATED);
		
	}
	
	@GetMapping("/getShow")
	public ResponseEntity<List<Show>> getShow(){
		return 	new ResponseEntity<List<Show>> (threatreService.getShow(), HttpStatus.OK);
	}
	
	@PostMapping("/addTheatre")
	public ResponseEntity<Theatre> addTheatre(@RequestBody Theatre theatre) throws Exception {
		return new ResponseEntity<Theatre>(threatreService.addTheatre(theatre) , HttpStatus.CREATED);
	}
	
	@GetMapping("/getTheatre")
	public ResponseEntity <List<Theatre>> getTheatre() {
		return new ResponseEntity<List<Theatre>>(threatreService.getTheatre() , HttpStatus.OK);
	}
	
//	public void addShow(int movieId, int threatreId, LocalDateTime movieStartTiming, LocalDateTime movieEndTiming ,LocalDate movieDate) {
//		
//		
//		LocalDate movieDate1 = LocalDate.of(2023,5, 2);
//		LocalDate movieDate2 = LocalDate.of(2023,5, 3);
//		LocalDate movieDate3 = LocalDate.of(2023,5, 4);
//		
//		LocalTime startTime1 = LocalTime.of(10, 30, 0); 
//		LocalTime endTime1 = LocalTime.of(13, 30, 0); 
//		
//		LocalTime startTime2 = LocalTime.of(15, 30, 0); 
//		LocalTime endTime2 = LocalTime.of(18, 30, 0); 
//		
//		LocalTime startTime3 = LocalTime.of(20, 30, 0); 
//		LocalTime endTime3 = LocalTime.of(23, 30, 0); 
//		
//		//LocalDateTime ti = LocalDateTime.of(movieDate3, endTime3)
//		
//		Set<Movie> movieList = MovieServiceImpl.getAllMovies();
//		List<Integer> movieIds =  movieList.stream().filter(s-> s.getMovieId() == movieId ).map(s-> s.getMovieId()).collect(Collectors.toList());
//		if(! movieIds.isEmpty()) {
//			//int movie = movieIds.get(0);
//			threatreService.addShowTIming(movieId, 2, startTime1, endTime1, movieDate1);
//			
//			
//		}else {
//			System.out.println("Invalid movie ID");
//		}
//		
//		
//	}

}

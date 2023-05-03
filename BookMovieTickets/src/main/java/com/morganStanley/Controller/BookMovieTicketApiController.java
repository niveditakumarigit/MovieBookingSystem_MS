package com.morganStanley.Controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.morganStanley.ServiceImp.MovieServiceImpl;
import com.morganStanley.model.BookMovieTickets;
import com.morganStanley.model.Movie;

@RestController
public class BookMovieTicketApiController {

	@Autowired
	MovieServiceImpl movieService;

	@PostMapping("/bookTicket")
	public ResponseEntity<HashMap<String, String>> bookMovieTicket(@RequestBody BookMovieTickets bookTickets) {
		return new ResponseEntity<HashMap<String, String>>(movieService.bookMovieTicket(bookTickets), HttpStatus.OK);
	}

}

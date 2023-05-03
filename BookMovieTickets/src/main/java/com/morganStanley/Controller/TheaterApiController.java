package com.morganStanley.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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
public class TheaterApiController {
	
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
		return new ResponseEntity<List<Theatre>>(threatreService.getAllTheatres() , HttpStatus.OK);
	}
}

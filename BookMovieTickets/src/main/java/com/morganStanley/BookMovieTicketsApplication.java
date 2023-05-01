package com.morganStanley;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.morganStanley.Controller.AdminController;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class BookMovieTicketsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookMovieTicketsApplication.class, args);
	}
	
	@PostConstruct
	public void MovieCreatedByAdmin() {
		
		AdminController admin = new AdminController();
		//admin.createMovie();		
		
	}

}

package com.morganStanley;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.morganStanley.Controller.AdminApiController;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class BookMovieTicketsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookMovieTicketsApplication.class, args);
	}
	
}

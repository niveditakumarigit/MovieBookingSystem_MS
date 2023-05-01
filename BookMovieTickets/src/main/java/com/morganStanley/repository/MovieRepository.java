package com.morganStanley.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.morganStanley.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer>{

}

package com.morganStanley.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.morganStanley.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer>{

}

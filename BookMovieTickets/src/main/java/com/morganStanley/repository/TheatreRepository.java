package com.morganStanley.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.morganStanley.model.Theatre;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Integer>{
	
}

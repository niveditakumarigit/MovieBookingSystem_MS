package com.morganStanley.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.morganStanley.model.Theatre;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Integer>{
	 
	//@Query("SELECT u FROM Theatre u JOIN FETCH u.show WHERE u.id = :theatre_id")
	//    Optional<Theatre> findTheathreWithShow();
	
	

}

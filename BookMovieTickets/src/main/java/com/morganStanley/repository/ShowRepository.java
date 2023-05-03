package com.morganStanley.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.morganStanley.model.Show;

@Repository
public interface ShowRepository extends JpaRepository<Show, Integer>{

	
	 @Query("select s from Show s where s.theatre.theatreId = :theatreId")
	 List<Show> findByTheatreId(@Param("theatreId") int theatreId);
}

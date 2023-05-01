package com.morganStanley.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.morganStanley.model.Show;
import com.morganStanley.model.Theatre;

public interface TheatreRepository extends JpaRepository<Theatre, Integer>{

}

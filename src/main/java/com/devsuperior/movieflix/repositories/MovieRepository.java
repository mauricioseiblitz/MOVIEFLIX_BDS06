package com.devsuperior.movieflix.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.devsuperior.movieflix.entities.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>{ 
	
	@Query("SELECT obj FROM Movie obj JOIN FETCH obj.reviews WHERE obj.id = :id")
	public List<Movie> findMovieWithReviews(Long id);
}

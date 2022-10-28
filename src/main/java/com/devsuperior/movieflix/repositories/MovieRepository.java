package com.devsuperior.movieflix.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>{ 
	
	@Query("SELECT obj FROM Movie obj JOIN FETCH obj.reviews WHERE obj.id = :id")
	List<Movie> findMovieWithReviews(Long id);
	
	@Query("SELECT obj FROM Movie obj INNER JOIN obj.genre genre "
			+ "WHERE :genre IN genre")
	Page<Movie> find(Genre genre, Pageable pageable);
}

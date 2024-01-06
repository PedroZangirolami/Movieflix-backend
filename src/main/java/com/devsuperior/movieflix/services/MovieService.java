package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.dto.MovieCardDTO;
import com.devsuperior.movieflix.dto.MovieDetailsDTO;
import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.repositories.GenreRepository;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.repositories.ReviewRepository;
import com.devsuperior.movieflix.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    ReviewRepository reviewRepository;

    public Page<MovieCardDTO> findByGenre(String genre,  Pageable pageable){
        Page<Movie> movies = movieRepository.findByGenre(genre,pageable);
        return movies.map(x -> new MovieCardDTO(x));
    }

    public MovieDetailsDTO findById(Long id){
        Movie result = movieRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
        return new MovieDetailsDTO(result);
    }

    public List<ReviewDTO> searchReviews(String movieId){
        List<Review> result = reviewRepository.searchByMovie(movieId);
        return result.stream().map(x -> new ReviewDTO(x)).collect(Collectors.toList());
    }

}

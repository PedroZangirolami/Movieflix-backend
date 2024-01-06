package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.dto.MovieCardDTO;
import com.devsuperior.movieflix.dto.MovieDetailsDTO;
import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.dto.UserDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repositories.ReviewRepository;
import com.devsuperior.movieflix.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    UserService userService;

    @Autowired
    MovieService movieService;

    public ReviewDTO insertReview(ReviewDTO dto){
       Review review = reviewRepository.save(copyToEntity(dto));
       review = reviewRepository.save(review);
       return new ReviewDTO(review);
    }

    private Review copyToEntity(ReviewDTO dto){
        Review review = new Review();
        UserDTO user = userService.getProfile();
        MovieDetailsDTO movie = movieService.findById(dto.getMovieId());

        review.setUser(new User(user.getId(), user.getName(), user.getEmail()));
        review.setMovie(new Movie(movie.getId(),movie.getTitle()));
        review.setText(dto.getText());

        return review;
    }


}

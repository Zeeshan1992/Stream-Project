package com.stream.project.src;

import java.util.ArrayList;
import org.springframework.http.HttpStatus;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

  @Autowired
  MovieRepository movieRepository;

  public ResponseEntity<List<Movie>> getMovies() {
    try {
      List<Movie> tutorials = new ArrayList<Movie>();
      movieRepository.findAll().forEach(tutorials::add);
      return new ResponseEntity<>(tutorials, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  public ResponseEntity<Movie> getMovieById(long movieId) {
    Optional<Movie> tutorialData = movieRepository.findById(movieId);
    if (tutorialData.isPresent()) {
      return new ResponseEntity<>(tutorialData.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  public ResponseEntity<Movie> addMovie(Movie movie) {
    try {
      Movie _movie = movieRepository
          .save(new Movie(movie.getRefID(), movie.getThumbnail(), movie.getDescription()));
      return new ResponseEntity<>(_movie, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  public ResponseEntity<HttpStatus> deleteMovie(Long movieId) {
    try {
      movieRepository.deleteById(movieId);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  public ResponseEntity<Movie> updateMovie(Movie movie, long movieId) {
    Optional<Movie> movieData = movieRepository.findById(movieId);
    if (movieData.isPresent()) {
      Movie _movie = movieData.get();
      _movie.setRefID(movie.getRefID());
      _movie.setDescription(movie.getDescription());
      _movie.setThumbnail(movie.getThumbnail());
      return new ResponseEntity<>(movieRepository.save(_movie), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}

package com.stream.project.src;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    
    private MovieRepository movieRepository;
    
    @Autowired
    public MovieService(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }


    public List<Movie> getMovies(){
        return movieRepository.findAll();
    }


    public Movie getMovieById(long movieId){
        Movie existingMovie = movieRepository.findById(movieId).orElseThrow(()-> new IllegalStateException("Movie with id " + movieId + " does not exist"));
        return existingMovie;
    }

    public void addMovie(Movie movie){
        movieRepository.save(movie);
    }

    public void deleteMovie(Long movieId){
        boolean exists = movieRepository.existsById(movieId);
        if(!exists){
            throw new IllegalStateException("movie with id " + movieId + " does not exist");
        }
        movieRepository.deleteById(movieId);
    }


    public Movie updateMovie(Movie movie, long movieId) {
        Movie existingMovie = movieRepository.findById(movieId).orElseThrow(()-> new IllegalStateException("Movie with id " + movieId + " does not exist"));
        existingMovie.setRefID(movie.getRefID());
        existingMovie.setDescription(movie.getDescription());
        existingMovie.setThumbnail(movie.getThumbnail());
        return existingMovie;

    }
}

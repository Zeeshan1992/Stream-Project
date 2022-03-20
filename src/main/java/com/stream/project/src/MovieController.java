package com.stream.project.src;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/movies")
public class MovieController {
    private final MovieService movieService;
    
    @Autowired
    public MovieController(MovieService movieService){
        this.movieService = movieService;
    }

    @GetMapping
    public List<Movie> getMovies(){
        return movieService.getMovies();
    }

    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable("id") long id){
        return movieService.getMovieById(id);
    }
    
    @PostMapping
    public void addMovie(@RequestBody Movie movie){
        movieService.addMovie(movie);
    }

    @DeleteMapping(path="{movieId}")
    public void deleteMovie(@PathVariable("movieId") Long id){
        movieService.deleteMovie(id);
    }

    @PutMapping("/{id}")
    public Movie updateMovie(@RequestBody Movie movie, @PathVariable("id") long movieId){
        return movieService.updateMovie(movie, movieId);
    }
}

package com.example.moviebookingbackend.Controller;

import com.example.moviebookingbackend.Model.Movies;
import com.example.moviebookingbackend.Repository.MoviesRepo;
import com.example.moviebookingbackend.Repository.TheatreRepo;
import com.example.moviebookingbackend.Service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin (origins = "http://localhost:4200")
public class MoviesController {
    @Autowired
    private MoviesService moviesService;

    @Autowired
    private MoviesRepo repository ;

    @Autowired
    private TheatreRepo theatreRepository ;

    @PostMapping("/addMovie")
    public Movies addProduct(@RequestBody Movies movie) {
        return moviesService.saveMovie(movie);
    }

    @PostMapping("/addMovies")
    public List<Movies> addMovie (@RequestBody List<Movies> movies){
        return moviesService.saveMovies(movies);
    }

    @GetMapping("/Movies")
    public List<Movies> findAllMovies(){
        return moviesService.getMovies();
    }

    @GetMapping("MovieById/{id}")
    public Movies findMoviesById(@PathVariable int id) {
        return moviesService.getMovieById(id);
    }

    @DeleteMapping("/movieDelete/{id}")
    public String deleteProduct(@PathVariable int id) {
        return moviesService.deleteMovie(id);
    }

    @GetMapping("/theatre/getbyid/{theatreid}")
    public List<Movies> slotById(@PathVariable("theatreid") Integer theatreid){
        return moviesService.getMoviesByTheatreById(theatreid);
    }

}

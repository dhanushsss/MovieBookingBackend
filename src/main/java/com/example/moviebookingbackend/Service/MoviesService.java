package com.example.moviebookingbackend.Service;



import com.example.moviebookingbackend.Model.Movies;
import com.example.moviebookingbackend.Repository.MoviesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoviesService {

    @Autowired
    private MoviesRepo moviesRepository;

    public Movies saveMovie(Movies movie) {
        return moviesRepository.save(movie);
    }

    public List<Movies> saveMovies(List<Movies> movies){
        return moviesRepository.saveAll(movies);
    }

    public List<Movies> getMoviesByTheatreById(int theatreid){
        return moviesRepository.getMoviesByTheatreById(theatreid);
    }

    public List<Movies> getMovies(){
        return moviesRepository.findAll();
    }

    public Movies getMovieById(int id) {
        return moviesRepository.findById(id).orElse(null);
    }


    public String deleteMovie(int id) {
        moviesRepository.deleteById(id);
        return "Product removed Succcessfully" +id;
    }

}


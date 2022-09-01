package com.example.moviebookingbackend.Service;

import com.example.moviebookingbackend.Model.Theatre;
import com.example.moviebookingbackend.Repository.TheatreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TheatreService {

    @Autowired
    private TheatreRepo repository ;

    public Theatre saveData(Theatre theatre){
        return repository.save(theatre);
    }

    public Theatre getMovieById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Theatre fetchUserByEmailAndPassword(String theatreEmail , String password) {
        return repository.findTheatreByTheatreEmailAndPassword(theatreEmail, password);
    }

}

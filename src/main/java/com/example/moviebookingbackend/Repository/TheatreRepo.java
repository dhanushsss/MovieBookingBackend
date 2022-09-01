package com.example.moviebookingbackend.Repository;

import com.example.moviebookingbackend.Model.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheatreRepo extends JpaRepository<Theatre,Integer> {
    public Theatre findTheatreByTheatreEmailAndPassword(String theatreEmail , String password);
}

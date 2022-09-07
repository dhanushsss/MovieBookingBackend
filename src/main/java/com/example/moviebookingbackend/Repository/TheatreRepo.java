package com.example.moviebookingbackend.Repository;

import com.example.moviebookingbackend.Model.Bookings;
import com.example.moviebookingbackend.Model.Movies;
import com.example.moviebookingbackend.Model.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TheatreRepo extends JpaRepository<Theatre,Integer> {
    public Theatre findTheatreByTheatreEmailAndPassword(String theatreEmail , String password);

    @Query("Select s from Bookings s where s.movies.theatre.theatreid =:theatreid")
    List<Bookings> getByTheatreById(int theatreid);

}

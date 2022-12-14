package com.example.moviebookingbackend.Repository;

import com.example.moviebookingbackend.Model.Bookings;
import com.example.moviebookingbackend.Model.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookingsRepo extends JpaRepository<Bookings , Integer> {
    @Query("select sum(totalCost) from Bookings where movies.theatre.theatreid=:theatreid")
    int getBookingsByBookingidtotal(@Param("theatreid") int theatreid);

}

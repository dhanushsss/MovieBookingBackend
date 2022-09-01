package com.example.moviebookingbackend.Service;

import com.example.moviebookingbackend.Model.Bookings;
import com.example.moviebookingbackend.Repository.BookingsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    @Autowired
    private BookingsRepo repository ;

    public Bookings saveData(Bookings bookings){
        return repository.save(bookings);
    }
    public Bookings getBookings(int id) {
        return repository.findById(id).orElse(null);
    }


    public int getBookingsByBookingidtotal(int theatreid){
        return repository.getBookingsByBookingidtotal(theatreid);
    }
    public  int getMovieByIdTotal(int movieid){
        return repository.getMovieByIdTotal(movieid);
    }
//    public Bookings totalNoOfticketsId(int Bookingid){
//        return repository.totalNoOfticketsId(Bookingid);
//    }


}

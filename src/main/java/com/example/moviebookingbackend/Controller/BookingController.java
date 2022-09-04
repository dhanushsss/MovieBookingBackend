package com.example.moviebookingbackend.Controller;

import com.example.moviebookingbackend.Model.Bookings;
import com.example.moviebookingbackend.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin (origins = "http://localhost:4200")
public class BookingController {

    @Autowired
    private BookingService bookingService ;

    @PostMapping("/addBooking")
    public Bookings saveData(@RequestBody Bookings bookings){
        return bookingService.saveData(bookings);
    }



    @GetMapping("BookingId/{id}")
    public Bookings findBookingId(@PathVariable int id) {
        return bookingService.getBookings(id);
    }

    @GetMapping("SumBooking/{theatreid}")
    public int getBookingsByBookingidtotal(@PathVariable int theatreid){
        return bookingService.getBookingsByBookingidtotal(theatreid);
    }


//    @GetMapping("movieTotal/{movieid}")
//    public int getMovieByIdTotal(@PathVariable int movieid){
//        return bookingService.getMovieByIdTotal(movieid);
//    }





}

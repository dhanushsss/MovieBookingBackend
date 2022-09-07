package com.example.moviebookingbackend.Service;

import com.example.moviebookingbackend.Model.Bookings;
import com.example.moviebookingbackend.Model.Theatre;
import com.example.moviebookingbackend.Repository.TheatreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


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
    public Optional<Theatre> getTheatreById (int id){
        return repository.findById(id);
    }

    public ResponseEntity<Double> calculateRevenue(int id, LocalDate bookingDate, LocalDate endDate) {
        Double revenue=0.0;
        Optional<Theatre> renter=getTheatreById(id);
        if(renter.isPresent()) {
            List<Bookings> bookings = repository.getByTheatreById(id);
            for(int i=0;i<bookings.size();i++) {
                if((bookingDate.isBefore(bookings.get(i).getBookingDate()) || bookingDate.isEqual(bookings.get(i).getBookingDate()))
                        &&
                        (endDate.isAfter(bookings.get(i).getBookingDate()) || endDate.isEqual(bookings.get(i).getBookingDate()))) {
                    revenue+=(bookings.get(i).getTotalCost());
                }
            }
        }
        return new ResponseEntity<>(revenue, HttpStatus.OK);
    }

}

package com.example.moviebookingbackend.Controller;

import com.example.moviebookingbackend.Model.Theatre;
import com.example.moviebookingbackend.Repository.TheatreRepo;
import com.example.moviebookingbackend.Service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TheatreController {

    @Autowired
    private TheatreService service ;

    @Autowired
    private TheatreRepo repository ;


    // theatre register

    @PostMapping("/theatre")
    public Theatre saveData(@RequestBody  Theatre theatre){
        return service.saveData(theatre);
    }

    //theatre login
    @PostMapping("/TheatreLogin")
    public int loginUser(@RequestBody Theatre theatre) throws Exception {
        String tempEmailId = theatre.getTheatreEmail();
        String tempPass = theatre.getPassword();
        Theatre userObj = null;
        if(tempEmailId != null && tempPass != null) {
            userObj = service.fetchUserByEmailAndPassword(tempEmailId, tempPass);
        }
        if(userObj == null) {
            throw new Exception("Bad credentials");
        }
        return userObj.getTheatreid();
    }


    // display movie data
    @GetMapping("/findAll")
    public List<Theatre> getData(){
        return repository.findAll();
    }


    //mapping find movie based on id
    @GetMapping("TheatreBy/{id}")
    public Theatre findMoviesById(@PathVariable int id) {
        return service.getMovieById(id);
    }

    //


    @GetMapping("/Revenue/{theatreid}/{bookingDate}/{endDate}")
    public ResponseEntity<Double> calculateRevenue(@PathVariable(value="theatreid")int id, @PathVariable(value = "bookingDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate bookingDate, @PathVariable(value = "endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate) {
        return service.calculateRevenue(id,bookingDate,endDate);
    }

}

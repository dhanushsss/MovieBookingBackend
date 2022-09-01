package com.example.moviebookingbackend.Controller;

import com.example.moviebookingbackend.Model.Theatre;
import com.example.moviebookingbackend.Repository.TheatreRepo;
import com.example.moviebookingbackend.Service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TheatreController {

    @Autowired
    private TheatreService service ;

    @Autowired
    private TheatreRepo repository ;

    @PostMapping("/theatre")
    public Theatre saveData(@RequestBody  Theatre theatre){
        return service.saveData(theatre);
    }

    @GetMapping("/findAll")
    public List<Theatre> getData(){
        return repository.findAll();
    }

    @GetMapping("TheatreBy/{id}")
    public Theatre findMoviesById(@PathVariable int id) {
        return service.getMovieById(id);
    }

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

}

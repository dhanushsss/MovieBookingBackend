package com.example.moviebookingbackend.Controller;

import com.example.moviebookingbackend.Model.FeedBack;
import com.example.moviebookingbackend.Service.feedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin (origins = "http://localhost:4200")
public class feedbackController {

    @Autowired
    private feedbackService service ;

    @PostMapping("/add")
    public FeedBack saveData(@RequestBody FeedBack module ){
        return service.saveDetails(module);
    }
    @GetMapping("/get")
    public List<FeedBack> getModule() {
        return service.getAll();
    }
}

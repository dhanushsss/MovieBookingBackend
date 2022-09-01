package com.example.moviebookingbackend.Service;


import com.example.moviebookingbackend.Model.FeedBack;
import com.example.moviebookingbackend.Repository.FeedBackRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class feedbackService {
    @Autowired
    private FeedBackRepo repository ;

    public FeedBack saveDetails(FeedBack module){
        return repository.save(module);
    }
    public List<FeedBack> getAll (){
        return repository.findAll();
    }
}

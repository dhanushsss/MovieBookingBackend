package com.example.moviebookingbackend.Repository;

import com.example.moviebookingbackend.Model.FeedBack;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedBackRepo extends JpaRepository<FeedBack , Long> {
}

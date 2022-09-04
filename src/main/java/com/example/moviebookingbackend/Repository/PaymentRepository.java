package com.example.moviebookingbackend.Repository;

import com.example.moviebookingbackend.Model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long>{
}
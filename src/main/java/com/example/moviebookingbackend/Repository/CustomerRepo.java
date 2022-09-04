package com.example.moviebookingbackend.Repository;

import com.example.moviebookingbackend.Model.Bookings;
import com.example.moviebookingbackend.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepo extends JpaRepository<Customer,Integer> {
    public Customer findByEmailAndPassword(String email , String password);
    public Customer findByEmail(String email);

    @Query("select a from Customer a where a.customerid=?1")
    public Customer findById(int id);

    @Query ("select b from Bookings b where b.customer.customerid=:customerid")
    List<Bookings> findCustomer (@Param("customerid") int customerid);

}

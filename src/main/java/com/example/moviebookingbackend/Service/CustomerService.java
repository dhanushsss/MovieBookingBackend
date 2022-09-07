package com.example.moviebookingbackend.Service;

import com.example.moviebookingbackend.Model.Bookings;
import com.example.moviebookingbackend.Model.Customer;
import com.example.moviebookingbackend.Repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo repository ;

    public Customer addData(Customer customer){
        return repository.save(customer);
    }
    public Customer saveUser(Customer user) {
        return repository.save(user);
    }

    public Customer fetchUserByEmail(String email) {
        return repository.findByEmail(email);
    }

    public Customer fetchUserByEmailAndPassword(String email , String password) {
        return repository.findByEmailAndPassword(email, password);
    }

    public Customer getUser(int id){
        return repository.findById(id);
    }

    public List<Bookings> findCustomer (int customerid){
        return repository.findCustomer(customerid);
    }


}

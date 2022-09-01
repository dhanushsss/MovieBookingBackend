package com.example.moviebookingbackend.Controller;


import com.example.moviebookingbackend.Model.Customer;
import com.example.moviebookingbackend.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @PostMapping("/customer")
    public Customer saveData(@RequestBody Customer customer){
        return service.addData(customer);
    }
    @PostMapping("/registered")
    public int registerUser(@RequestBody Customer user) throws Exception {
        String tempEmailId  = user.getEmail();
        if(tempEmailId != null && !"".equals(tempEmailId)) {
            Customer userobj = service.fetchUserByEmail(tempEmailId);
            if(userobj != null) {
                throw new Exception("user with "+tempEmailId+" is already exit");
            }
        }
        Customer userObj = null;
        userObj = service.saveUser(user);
        return userObj.getCustomerid();
    }

    @PostMapping("/login")
    public int loginUser(@RequestBody Customer user) throws Exception {
        String tempEmailId = user.getEmail();
        String tempPass = user.getPassword();
        Customer userObj = null;
        if(tempEmailId != null && tempPass != null) {
            userObj = service.fetchUserByEmailAndPassword(tempEmailId, tempPass);
        }
        if(userObj == null) {
            throw new Exception("Bad credentials");
        }
        return userObj.getCustomerid();
    }

    @GetMapping("/getUserByid/{id}")
    public Customer getUserByid(@PathVariable int id){
        return service.getUser(id);
    }


}

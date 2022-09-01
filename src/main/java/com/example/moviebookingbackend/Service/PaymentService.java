package com.example.moviebookingbackend.Service;
import com.example.moviebookingbackend.Model.Payment;
import com.example.moviebookingbackend.Repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public boolean checkPayment(Payment admin) {
        if(paymentRepository.existsById(admin.getCardNumber())) {
            Payment currentAdmin = paymentRepository.findById(admin.getCardNumber()).get();

            if(currentAdmin.getCustomerName().equals(admin.getCustomerName()) && currentAdmin.getCvv().equals(admin.getCvv())
                    && currentAdmin.getExpireDate().equals(admin.getExpireDate())) {
                //	System.out.println("Login Successfull ");
                return true;
            }
            else {
                return false;
            }
        }else {

            return false;
        }

    }
}

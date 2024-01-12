package com.exercise.bankingapp.controller;

import com.exercise.bankingapp.entity.Customer;
import com.exercise.bankingapp.request.CustomerRequest;
import com.exercise.bankingapp.service.BankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    @Autowired
    BankingService bankingService;

    @PostMapping(value = "/register")
    public String facilitateCustomerRegistration(@RequestBody CustomerRequest registrationRequest){
        String customer = bankingService.registerCustomer(registrationRequest);
        return customer;
    }

    @GetMapping(value = "/getmap")
    public String getstr() {
        return "HELLO!";
    }

    @GetMapping(value = "/getCustomers")
    public String getCustomer(){
        String customer = bankingService.getFirst();
        return customer;
    }

}

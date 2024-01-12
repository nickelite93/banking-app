package com.exercise.bankingapp.service;

import com.exercise.bankingapp.entity.CurrentAccount;
import com.exercise.bankingapp.entity.Customer;
import com.exercise.bankingapp.repository.CurrentAccountRepository;
import com.exercise.bankingapp.repository.CustomerRepository;
import com.exercise.bankingapp.request.CustomerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class BankingService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CurrentAccountRepository currentAccountRepository;

    public String registerCustomer(CustomerRequest customerRequest){
        BigDecimal value = new BigDecimal(0.00);
        CurrentAccount account = new CurrentAccount(value);
        currentAccountRepository.save(account);

        Customer customer = new Customer(customerRequest);
        customer.setCurrentAccount(account);
        Customer customer1 = customerRepository.save(customer);
        System.out.println(customer1.getId());
        return "Success";
    }

    public String getFirst(){
        List<Customer> customer = customerRepository.findAll();
        Customer cust = customer.get(0);
        List<CurrentAccount> account = currentAccountRepository.findAll();
        CurrentAccount acc = account.get(0);
        System.out.println(cust.getCurrentAccount().getBalance());
        return cust.getFirstName();
    }
}

package com.exercise.bankingapp.entity;

import jakarta.persistence.*;
import lombok.Data;
import com.exercise.bankingapp.request.*;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Customer {

    public Customer(CustomerRequest customerRequest){
        this.firstName = customerRequest.getFirstName();
        this.lastName = customerRequest.getLastName();
    }

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    @OneToOne
    @JoinColumn(name = "currentAccount_id", referencedColumnName = "id")
    private CurrentAccount currentAccount;

}

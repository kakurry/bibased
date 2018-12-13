package com.example.bibased.mongDBjavabean;


import lombok.Data;

import javax.persistence.Id;


@Data
public class Customer {

    @Id
    public String id;

    public String firstName;
    public String lastName;

    public Customer() {
    }

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
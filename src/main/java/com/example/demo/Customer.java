package com.example.demo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Customer {

     @Id
     @GeneratedValue
     Integer id;

     String firstName;
     
     String lastName;
     
     LocalDate birthday;
     
     String gender;
     
     boolean married;
    
}
    

package com.ijse.springbootFinalCW.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name= "users")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) 

    private Long id;
    private String username;
    private String password;

    @ElementCollection(fetch=FetchType.EAGER)
    private Set<String> roles= new HashSet<>();
    
}

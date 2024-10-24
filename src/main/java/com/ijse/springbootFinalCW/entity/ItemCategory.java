package com.ijse.springbootFinalCW.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="item_categories")
public class ItemCategory {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) 
    private Long id;
    private String name;
    

    
}

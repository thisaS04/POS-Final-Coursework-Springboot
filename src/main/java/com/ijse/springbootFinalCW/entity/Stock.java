package com.ijse.springbootFinalCW.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="stocks")
public class Stock {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) 
     private Long stockId;
    

     @ManyToOne
     @JoinColumn(name="item_id")
     private Item item;
     private Integer quantity;
}

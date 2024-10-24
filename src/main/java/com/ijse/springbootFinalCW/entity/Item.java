package com.ijse.springbootFinalCW.entity;

import java.math.BigDecimal;

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
@Table(name="items")
public class Item {
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY) 
   private Long id;
   private String name;
   private Double price;

   @ManyToOne
   @JoinColumn(name = "category_id")
   private ItemCategory category;
   
}

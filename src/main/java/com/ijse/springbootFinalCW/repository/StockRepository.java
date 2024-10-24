package com.ijse.springbootFinalCW.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ijse.springbootFinalCW.entity.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
    
}

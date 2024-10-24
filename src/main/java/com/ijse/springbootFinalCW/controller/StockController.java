package com.ijse.springbootFinalCW.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ijse.springbootFinalCW.entity.Stock;
import com.ijse.springbootFinalCW.service.StockService;

@RestController
@CrossOrigin(origins ="*")

@RequestMapping("/stock")
public class StockController {

@Autowired
private StockService stockService;

 @GetMapping("/stocks")
    public ResponseEntity<List<Stock>> getAllStocks() {
        List<Stock> stocks = stockService.getAllStocks();
        return ResponseEntity.status(200).body(stocks);
}
 @PostMapping("/stocks")
    public ResponseEntity<Stock> createStock(@RequestBody Stock stock) {
        try {
            Stock createdStock = stockService.createStock(stock);
            return ResponseEntity.status(201).body(createdStock);
        } catch (Exception e) {
            return ResponseEntity.status(400).body(null);
        }
    }
     @PutMapping("/stocks/{id}")
    public ResponseEntity<Stock> updateStock(@PathVariable Long id, @RequestBody Stock stock) {
        Stock updatedStock = stockService.updateStock(id, stock);
        if (updatedStock == null) {
            return ResponseEntity.status(404).body(null);
        } else {
            return ResponseEntity.ok(updatedStock);
        }
    }
}


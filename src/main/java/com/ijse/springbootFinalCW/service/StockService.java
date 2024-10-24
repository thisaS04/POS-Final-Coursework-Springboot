package com.ijse.springbootFinalCW.service;

import java.util.List;

import org.springframework.stereotype.Service;


import com.ijse.springbootFinalCW.entity.Stock;


@Service
public interface StockService {
   Stock createStock(Stock stock);
   Stock updateStock(Long id, Stock stock);
   List<Stock> getAllStocks();
   void deleteStock(Long id);
}
   

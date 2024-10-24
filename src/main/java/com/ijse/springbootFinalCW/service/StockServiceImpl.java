package com.ijse.springbootFinalCW.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ijse.springbootFinalCW.entity.Stock;

import com.ijse.springbootFinalCW.repository.StockRepository;


@Service
public class StockServiceImpl implements StockService {
@Autowired
private StockRepository stockRepository;

@Override
public Stock createStock(Stock stock) {
  return stockRepository.save(stock);
}

@Override
public Stock updateStock(Long id, Stock stock) {
  if (!stockRepository.existsById(id)) 
  return null;
  stock.setStockId(id);
  return stockRepository.save(stock);

}

@Override
public List<Stock> getAllStocks() {
List<Stock>stocks =stockRepository.findAll();
List<Stock> stockList = new ArrayList<>();
for (Stock stock : stocks) {
    stockList.add(stock);
}
return stockList;
  
}


@Override
public void deleteStock(Long id) {
  if (stockRepository.existsById(id)) stockRepository.deleteById(id);
  
}
  
 
   
  }
  

    
    


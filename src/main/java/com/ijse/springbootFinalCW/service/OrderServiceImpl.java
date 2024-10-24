package com.ijse.springbootFinalCW.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ijse.springbootFinalCW.entity.Order;
import com.ijse.springbootFinalCW.repository.OrderRepository;

public class OrderServiceImpl implements OrderService{
      @Autowired
    private OrderRepository orderRepository;


    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order getOrderById(Long orderId) {
        return orderRepository.findById(orderId)
        .orElseThrow(() -> new RuntimeException("Order not found")); 
      
    }

   
    }



        

    


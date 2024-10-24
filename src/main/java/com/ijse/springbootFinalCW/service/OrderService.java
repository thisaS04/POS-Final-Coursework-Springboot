package com.ijse.springbootFinalCW.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ijse.springbootFinalCW.entity.Order;



@Service
public interface OrderService {
    List<Order> getAllOrders();

    Order createOrder(Order order);

    Order getOrderById(Long orderId);
}

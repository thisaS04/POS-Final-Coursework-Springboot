package com.ijse.springbootFinalCW.dto;

import java.sql.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class OrderDto {
    private Long id;
    private Long userId;
    private Date orderDate;
    private Double totalPrice;
}

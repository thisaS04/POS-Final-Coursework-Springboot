package com.ijse.springbootFinalCW.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class StockDto {
    private Long id;
    private Integer quantity;
    private Long itemId;
    private String itemName;
    
}

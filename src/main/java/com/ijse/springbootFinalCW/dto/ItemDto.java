package com.ijse.springbootFinalCW.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemDto {
    private Long id;
    private String name;
    private Double price;
    private Long categoryId;
}

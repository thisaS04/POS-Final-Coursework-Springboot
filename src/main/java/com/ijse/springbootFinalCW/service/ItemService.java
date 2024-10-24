package com.ijse.springbootFinalCW.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.ijse.springbootFinalCW.dto.ItemDto;


@Service
public interface ItemService {
  ItemDto createItem(ItemDto itemDto);
  ItemDto getItemById(Long id);
  List<ItemDto> getAllItems();
  ItemDto updateItem(Long id,ItemDto itemDto);
  void deleteItem(Long id);
    
    
}

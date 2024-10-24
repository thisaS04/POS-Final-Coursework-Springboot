package com.ijse.springbootFinalCW.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ijse.springbootFinalCW.dto.ItemDto;
import com.ijse.springbootFinalCW.service.ItemService;

@RestController
@CrossOrigin(origins = "*")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping("/item")
    public ResponseEntity<List<ItemDto>> getAllItems() {
        List<ItemDto> items = itemService.getAllItems();
        return ResponseEntity.status(200).body(items);
    }

    @GetMapping("/item/{itemId}")
    public ResponseEntity<ItemDto> getItemById(@PathVariable Long itemId) {
        ItemDto itemDto = itemService.getItemById(itemId);
        if (itemDto == null) {
            return ResponseEntity.status(404).body(null);
        } else {
            return ResponseEntity.status(200).body(itemDto);
        }
    }
    @PostMapping("/item")
    public ResponseEntity<ItemDto> createItem(@RequestBody ItemDto itemDto) {
        try {
            ItemDto createdItemDto = itemService.createItem(itemDto);
            return ResponseEntity.status(201).body(createdItemDto);
        } catch (Exception e) {
            return ResponseEntity.status(400).body(null);
        }
    }
    @PutMapping("/item/{itemId}")
    public ResponseEntity<ItemDto>updateItem(@PathVariable Long itemId,@RequestBody ItemDto itemDto){
        ItemDto updatedItemDto =itemService.updateItem(itemId,itemDto);
        if(updatedItemDto ==null){
            return ResponseEntity.status(404).body(null);

        } else{
            return ResponseEntity.status(200).body(updatedItemDto);
        }
    }
    @DeleteMapping("/item/{itemId}")
    public void deleteItem(@PathVariable Long itemId){
        itemService.deleteItem(itemId);
       
    }
}


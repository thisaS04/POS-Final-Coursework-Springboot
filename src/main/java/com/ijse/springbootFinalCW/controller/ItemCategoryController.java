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
import org.springframework.web.bind.annotation.RestController;

import com.ijse.springbootFinalCW.dto.ItemCategoryDto;
import com.ijse.springbootFinalCW.entity.ItemCategory;
import com.ijse.springbootFinalCW.service.ItemCategoryService;

@RestController
@CrossOrigin(origins = "*")
public class ItemCategoryController {
    
    @Autowired
    private ItemCategoryService itemCategoryService;

    @GetMapping
    public ResponseEntity<List<ItemCategoryDto>> getAllItemCategories() {
        List<ItemCategoryDto> categories = itemCategoryService.getAllCategories();
        return ResponseEntity.status(200).body(categories);
}
    @GetMapping("/itemcategory/{Id}")
    public ResponseEntity<Object> getItemCategryById(@PathVariable Long Id) {
        ResponseEntity<Object> category = ((ItemCategoryController) itemCategoryService).getItemCategryById(Id);
        if (category == null) {
            return ResponseEntity.status(404).body(null);
        } else {
            return ResponseEntity.status(200).body(category);
        }
}
@PostMapping("/itemcategory")
public ResponseEntity<?> createItemCategory(@RequestBody ItemCategoryDto categoryDto) { 
    try {
        ItemCategory createdCategory = itemCategoryService.createCategory(categoryDto); 
    } catch (Exception e) {
        return ResponseEntity.status(400).body(e.getMessage());
    }
    return null;
}

@PutMapping("/itemcategory/{categoryId}")
public ResponseEntity<ItemCategoryDto> updateItemCategory(@PathVariable Long categoryId, @RequestBody ItemCategoryDto categoryDto) { 
    ItemCategoryDto updatedCategory = itemCategoryService.updateCategory(categoryId, categoryDto); 
    if (updatedCategory == null) {
        return ResponseEntity.status(404).body(null);
    } else {
        return ResponseEntity.status(200).body(updatedCategory);
    }
}


public void deleteItemCategory(@PathVariable("categoryId") Long categoryId) {
    itemCategoryService.deleteCategory(categoryId);
}
}
package com.ijse.springbootFinalCW.service;



import java.util.List;

import org.springframework.stereotype.Service;

import com.ijse.springbootFinalCW.dto.ItemCategoryDto;




@Service
public interface ItemCategoryService {
   ItemCategoryDto createCategory(ItemCategoryDto categoryDto);
   List<ItemCategoryDto> getAllCategories();
    ItemCategoryDto getCategoryById(Long id);
    ItemCategoryDto updateCategory(Long id, ItemCategoryDto categoryDto);
    void deleteCategory(Long id);
    
}

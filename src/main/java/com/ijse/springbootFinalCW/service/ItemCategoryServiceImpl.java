package com.ijse.springbootFinalCW.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijse.springbootFinalCW.dto.ItemCategoryDto;
import com.ijse.springbootFinalCW.entity.ItemCategory;
import com.ijse.springbootFinalCW.repository.ItemCategoryRepository;




@Service
public class ItemCategoryServiceImpl implements ItemCategoryService {

@Autowired
private ItemCategoryRepository itemCategoryRepository;
    @Override
    public ItemCategoryDto createCategory(ItemCategoryDto categoryDto) {
       ItemCategory category = new ItemCategory();
       category.setName(categoryDto.getName());
       itemCategoryRepository.save(category);

       categoryDto.setId(category.getId());
       return categoryDto;
    }

    @Override
    public List<ItemCategoryDto> getAllCategories() {
        List<ItemCategory> categories = itemCategoryRepository.findAll(); 
        List<ItemCategoryDto> categoryDtos = new ArrayList<>();
        for (ItemCategory category : categories) {
            ItemCategoryDto dto = new ItemCategoryDto();
            dto.setId(category.getId());
            dto.setName(category.getName());
            categoryDtos.add(dto);
        }
        return categoryDtos;
    }

    @Override
    public ItemCategoryDto getCategoryById(Long id) {
        Optional<ItemCategory> optionalCategory = itemCategoryRepository.findById(id); 
        if (optionalCategory.isPresent()) {
            ItemCategory category = optionalCategory.get(); 
            ItemCategoryDto dto = new ItemCategoryDto();
            dto.setId(category.getId());
            dto.setName(category.getName());
            return dto; 
        }
        return null;
    }

    @Override
    public ItemCategoryDto updateCategory(Long id, ItemCategoryDto categoryDto) {
        Optional<ItemCategory> optionalCategory = itemCategoryRepository.findById(id); 
        if (optionalCategory.isPresent()) {
            ItemCategory category = optionalCategory.get(); 
            category.setName(categoryDto.getName());
            itemCategoryRepository.save(category);
            categoryDto.setId(category.getId());
            return categoryDto;

    }
    return null;
}

    @Override
    public void deleteCategory(Long id) {
       itemCategoryRepository.deleteById(id);
    }

   

   


   

    }
    


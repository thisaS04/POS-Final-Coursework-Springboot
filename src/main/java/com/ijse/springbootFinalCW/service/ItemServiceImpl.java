package com.ijse.springbootFinalCW.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijse.springbootFinalCW.dto.ItemDto;
import com.ijse.springbootFinalCW.entity.Item;
import com.ijse.springbootFinalCW.repository.ItemRepository;



@Service
public class ItemServiceImpl implements ItemService{
@Autowired
    private ItemRepository itemRepository;

    @Override
    public ItemDto createItem(ItemDto itemDto) {
       Item item = new Item();
       item.setName(itemDto.getName());
       item.setPrice(itemDto.getPrice());
       item.setCategory(item.getCategory());

       itemRepository.save(item);

       itemDto.setId(item.getId());
       return itemDto;



    }

    @Override
    public ItemDto getItemById(Long id) {
        Optional<Item> item = itemRepository.findById(id);
        if (item.isPresent()) {
            ItemDto dto = new ItemDto();
            dto.setId(item.get().getId());
            dto.setName(item.get().getName());
            dto.setPrice(item.get().getPrice());
            dto.setCategoryId(item.get().getCategory().getId());
            return dto;
        }
        return null;
    }

    @Override
    public List<ItemDto> getAllItems() {
       List<Item> items =itemRepository.findAll();
       List<ItemDto> itemDtos = new ArrayList<>();
       for(Item item:items){
        ItemDto dto = new ItemDto();
            dto.setId(item.getId());
            dto.setName(item.getName());
            dto.setPrice(item.getPrice());
            dto.setCategoryId(item.getCategory().getId()); 

            itemDtos.add(dto);


       }
       return itemDtos;
    }

    @Override
    public ItemDto updateItem(Long id, ItemDto itemDto) {

        Item item=itemRepository.findById(id).orElseThrow(() -> new RuntimeException("Item not found"));
        item.setName(itemDto.getName());
        item.setPrice(itemDto.getPrice());
        itemRepository.save(item);

        itemDto.setId(item.getId());
        return itemDto;
      
    }

    @Override
    public void deleteItem(Long id) {
        itemRepository.deleteById(id);

    }
    

    
        
    }

    
    


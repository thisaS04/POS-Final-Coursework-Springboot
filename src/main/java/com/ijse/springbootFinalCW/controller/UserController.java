package com.ijse.springbootFinalCW.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ijse.springbootFinalCW.dto.UserDto;
import com.ijse.springbootFinalCW.entity.User;
import com.ijse.springbootFinalCW.service.UserService;

@RestController
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private UserService userService;
   

@PostMapping("/users")
    public ResponseEntity<User> createUser (@RequestBody UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword()); 

        User createdUser  = userService.createUser (user);
        return ResponseEntity.status(201).body(createdUser );
    }


    
}

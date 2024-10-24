package com.ijse.springbootFinalCW.service;

import org.springframework.stereotype.Service;

import com.ijse.springbootFinalCW.dto.UserDto;

@Service
public interface UserService {
    UserDto registerUser(UserDto userDto);
    UserDto findByUsername(String username);
}

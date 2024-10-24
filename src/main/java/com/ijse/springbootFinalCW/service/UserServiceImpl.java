package com.ijse.springbootFinalCW.service;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.ijse.springbootFinalCW.entity.User;
import com.ijse.springbootFinalCW.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService{
@Autowired
private  UserRepository userRepository;
@Autowired
private PasswordEncoder passwordEncoder;

    @Override
    public User createUser(User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

   
    
}

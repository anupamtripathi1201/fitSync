package com.project.fitness.services;

import org.springframework.stereotype.Service;

import com.project.fitness.model.User;
import com.project.fitness.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServices {

    private final UserRepository userRepository;

    public User register(User user){

        return userRepository.save(user);
        
    }
    
}

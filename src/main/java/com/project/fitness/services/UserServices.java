package com.project.fitness.services;
import java.util.*;
import java.time.Instant;
import java.time.ZoneOffset;

import org.springframework.stereotype.Service;

import com.project.fitness.dto.RegisterRequest;
import com.project.fitness.dto.UserResponse;
import com.project.fitness.model.User;
import com.project.fitness.repository.UserRepository;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Builder
public class UserServices {

    private final UserRepository userRepository;

    public UserResponse register(RegisterRequest registerRequest){

        User user = new User().builder().email(registerRequest.getEmail()).password(registerRequest.getPassword()).firstName(registerRequest.getFirstName()).lastName(registerRequest.getLastName()).build();




//         User user = new User(
//             null,registerRequest.getEmail(),registerRequest.getPassword(),registerRequest.getFirstName(),registerRequest.getLastName(),
//             Instant.parse("2025-12-08T14:49:41.208Z")
//        .atZone(ZoneOffset.UTC)
//        .toLocalDateTime(),

// Instant.parse("2025-12-08T14:49:41.208Z")
//        .atZone(ZoneOffset.UTC)
//        .toLocalDateTime(),

// List.of(),
// List.of()

//         );

User savedUser = userRepository.save(user);
        UserResponse u= new UserResponse();
        u.setEmail(savedUser.getEmail());
        u.setId(savedUser.getId());
        u.setPassword(savedUser.getPassword());
        u.setFirstName(savedUser.getFirstName());
        u.setLastName(savedUser.getLastName());
        u.setCreatedAt(savedUser.getCreatedAt());
        u.setUpdatedAt(savedUser.getUpdatedAt());
return u;
        
    }
    
}

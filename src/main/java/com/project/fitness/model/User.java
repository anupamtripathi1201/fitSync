package com.project.fitness.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

@Id
@GeneratedValue(strategy = GenerationType.UUID)
private String id;
private String email;
private String password;
private String firstName;
private String lastName;
private LocalDateTime createdAt;
private LocalDateTime updatedAt;
    
}

package com.project.fitness.model;

import java.time.LocalDateTime;
import java.util.Map;

import org.hibernate.annotations.JdbcType;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
// @Table(name = "activities")
public class Activity {
    
    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    private String id;

    private Integer duration;
    private Integer caloriesBurned;
    private LocalDateTime startTime;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
    @Enumerated(EnumType.STRING)
    private ActivityType type;


    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition =  "json")
    private Map<String,Object> additionMetrics;

    
}

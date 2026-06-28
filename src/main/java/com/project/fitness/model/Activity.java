package com.project.fitness.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.annotations.JdbcType;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.mapping.Array;
import org.hibernate.type.SqlTypes;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
// @Table(name = "activities")
@Data
@AllArgsConstructor
@NoArgsConstructor
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

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false,foreignKey = @ForeignKey(name = "fk_user_id"))
    @JsonIgnore
    private User user;

    @OneToMany(mappedBy = "activities",cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonIgnore
    private List<Reccomendation> reccomendation = new ArrayList<>();

    
}

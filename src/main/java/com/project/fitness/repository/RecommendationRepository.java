package com.project.fitness.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.fitness.model.Recommendation;
import java.util.*;


public interface RecommendationRepository extends JpaRepository<Recommendation,String> {

    List<Recommendation> findByUserId(String userId);

    List<Recommendation> findByActivitiesId(String activityId);
    
}

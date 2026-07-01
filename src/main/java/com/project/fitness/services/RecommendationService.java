package com.project.fitness.services;

import java.util.List;

import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import com.project.fitness.dto.RecommendationRequest;
import com.project.fitness.model.Activity;
import com.project.fitness.model.Recommendation;
import com.project.fitness.model.User;
import com.project.fitness.repository.ActivityRepository;
import com.project.fitness.repository.RecommendationRepository;
import com.project.fitness.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RecommendationService {

    UserRepository userRepository;
    ActivityRepository activityRepository;
    RecommendationRepository recommendationRepository;

    public Recommendation generateRecommendation(RecommendationRequest request){
           User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Activity activity = activityRepository.findById(request.getActivityId())
                .orElseThrow(() -> new RuntimeException("Activity not found"));

        Recommendation recommendation = new Recommendation();

        recommendation.setUser(user);
        recommendation.setActivities(activity);

        recommendation.setImprovements(request.getImprovements());
        recommendation.setSuggestions(request.getSuggestions());
        recommendation.setSafetyTips(request.getSafetyTips());

       
        recommendation.setType("GENERAL");
        recommendation.setRecommendation("Keep maintaining your fitness routine.");

        return recommendationRepository.save(recommendation);




    }

    public List<Recommendation> getRecommendationsByUserId(String userId) {
        return recommendationRepository.findByUserId(userId);
    }

   public List<Recommendation> getRecommendationsByActivityId(String activityId)
{
    return recommendationRepository.findByActivitiesId(activityId);
}    
}

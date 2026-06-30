package com.project.fitness.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.fitness.dto.ActivityRequest;
import com.project.fitness.dto.ActivityResponse;
import com.project.fitness.model.Activity;
import com.project.fitness.model.User;
import com.project.fitness.repository.ActivityRepository;
import com.project.fitness.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ActivityService {
    private final ActivityRepository activity_repository;
    private final UserRepository user_repo;
    public ActivityResponse trackActivity(ActivityRequest activity_request){
        User user = user_repo.findById(activity_request.getUser_id()).orElseThrow(()->new RuntimeException("Invalid User"));
        Activity activity = new Activity().builder().user(user).duration(activity_request.getDuration()).caloriesBurned(activity_request.getCaloriesBurned()).type(activity_request.getType()).startTime(activity_request.getStartTime()).additionMetrics(activity_request.getAdditionMetrics()).build();

       Activity saved_Activity= activity_repository.save(activity);

        ActivityResponse response = new ActivityResponse();
        response.setId(saved_Activity.getId());
        response.setUser_id(saved_Activity.getUser().getId());
        response.setType(saved_Activity.getType());
        response.setCaloriesBurned(saved_Activity.getCaloriesBurned());
        response.setCreatedAt(saved_Activity.getCreatedAt());
        response.setUpdatedAt(saved_Activity.getUpdatedAt());
        response.setAdditionMetrics(saved_Activity.getAdditionMetrics());
        response.setDuration(saved_Activity.getDuration());
        response.setStartTime(saved_Activity.getStartTime());

        return response;


    }
}

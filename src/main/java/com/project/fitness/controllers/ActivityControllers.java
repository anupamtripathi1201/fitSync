package com.project.fitness.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.fitness.dto.ActivityRequest;
import com.project.fitness.dto.ActivityResponse;
import com.project.fitness.services.ActivityService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/activities")
@RequiredArgsConstructor
public class ActivityControllers {
   private final ActivityService activityService;

    

    @PostMapping("/trackActivity")
    public ResponseEntity<ActivityResponse> trackActivity(@RequestBody ActivityRequest activity_request){

        return ResponseEntity.ok(activityService.trackActivity(activity_request));
        

        
    }

    @GetMapping("/getActivity")
    public ResponseEntity<List<ActivityResponse>> getUserActivity(@RequestHeader(value = "X-ID-USER") String userId){


    return ResponseEntity.ok(activityService.getActivity(userId));
    }
   

    
}

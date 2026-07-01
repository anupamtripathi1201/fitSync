package com.project.fitness.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.fitness.model.Activity;
import com.project.fitness.model.Recommendation;

import com.project.fitness.services.RecommendationService;
import com.project.fitness.dto.*;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/reccomendation")
@RequiredArgsConstructor
public class RecommendationContollers {
    private final RecommendationService recomService;

    @PostMapping("/generate")
    public ResponseEntity<Recommendation> generateReccomendation(@RequestBody RecommendationRequest recomReq){

        return ResponseEntity.ok(recomService.generateRecommendation(recomReq));

    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Recommendation>> getByUser(@RequestParam String userId){
        return ResponseEntity.ok(recomService.getRecommendationsByUserId(userId));
    }

    @GetMapping("/activity/{activityId}")
    public ResponseEntity<List<Recommendation>> getByActivity(@RequestParam String activityId){
        return ResponseEntity.ok(recomService.getRecommendationsByActivityId(activityId));
    }
    
}

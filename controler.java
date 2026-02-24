package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.service.PlacementService;

@RestController
@RequestMapping("/api")
public class PlacementController {

    @Autowired
    private PlacementService service;

    @PostMapping("/predict")
    public String predict(@RequestParam int totalStudents,
                          @RequestParam double avgCGPA) {

        boolean result = service.predict(totalStudents, avgCGPA);

        if(result)
            return "High Company Visit Expected";
        else
            return "Low Company Visit Expected";
    }
}
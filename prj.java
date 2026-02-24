package com.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "placements")
public class Placement {

    @Id
    private String id;
    private int year;
    private int totalStudents;
    private double avgCGPA;
    private int companiesVisited;
    private boolean predictedHighVisit;

    // Getters and Setters
}
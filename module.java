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

    }
import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.model.Placement;

public interface PlacementRepository 
       extends MongoRepository<Placement, String> {
}
package com.example.service;

import org.springframework.stereotype.Service;
import smile.classification.RandomForest;

@Service
public class PlacementService {

    public boolean predict(int totalStudents, double avgCGPA) {

        double[][] X = {
                {400, 7.1},
                {420, 7.3},
                {450, 7.5},
                {380, 6.8}
        };

        int[] y = {0, 1, 1, 0};  // 1 = High Visit, 0 = Low Visit

        RandomForest model = RandomForest.fit(X, y);

        double[] newData = {totalStudents, avgCGPA};

        int prediction = model.predict(newData);

        return prediction == 1;
    }
}
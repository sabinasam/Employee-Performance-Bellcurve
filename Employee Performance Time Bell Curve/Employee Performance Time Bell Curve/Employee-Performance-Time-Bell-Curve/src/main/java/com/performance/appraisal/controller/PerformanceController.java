package com.performance.appraisal.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/performance")
public class PerformanceController {

    @PostMapping("/calculate")
    public ResponseEntity<?> calculatePerformance(@RequestBody EmployeeRequest request) {
        // Get Employee ID from the request body
        Long employeeId = request.getEmployeeId();

        // Logic for calculating performance based on Employee ID
        // You can implement any logic like fetching employee details from the database

        // Return a response
        return ResponseEntity.ok().body("Performance calculation completed for Employee ID: " + employeeId);
    }
}

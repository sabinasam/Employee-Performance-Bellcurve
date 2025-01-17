package com.performance.appraisal.service;

import com.performance.appraisal.model.Employee;
import com.performance.appraisal.model.RatingCategory;
import com.performance.appraisal.repository.EmployeeRepository;
import com.performance.appraisal.repository.RatingCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PerformanceService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private RatingCategoryRepository ratingCategoryRepository;

    public void calculateAndSuggest() {
        List<Employee> employees = employeeRepository.findAll();
        Map<String, Integer> categoryCounts = new HashMap<>();

        // Count employees in each category
        for (Employee employee : employees) {
            String category = getCategory(employee.getRating());
            categoryCounts.put(category, categoryCounts.getOrDefault(category, 0) + 1);
        }

        // Calculate actual percentages
        double totalEmployees = employees.size();
        Map<String, Double> actualPercentages = new HashMap<>();
        for (Map.Entry<String, Integer> entry : categoryCounts.entrySet()) {
            actualPercentages.put(entry.getKey(), (entry.getValue() / totalEmployees) * 100);
        }

        // Get rating category standards
        List<RatingCategory> categories = ratingCategoryRepository.findAll();

        // Compare actual vs standard
        for (RatingCategory category : categories) {
            double standardPercentage = category.getStandardPercentage();
            double actualPercentage = actualPercentages.get(category.getCategory());

            double deviation = actualPercentage - standardPercentage;
            System.out.println("Category: " + category.getCategory() + " Deviation: " + deviation);

            // Suggest changes if deviation is high
            if (Math.abs(deviation) > 10) {
                suggestRatingChange(category.getCategory());
            }
        }
    }

    private String getCategory(int rating) {
        if (rating == 1) return "A";
        if (rating == 2) return "B";
        if (rating == 3) return "C";
        if (rating == 4) return "D";
        return "E";
    }

    private void suggestRatingChange(String category) {
        System.out.println("Recommendation: Revise the ratings for category " + category);
    }
}

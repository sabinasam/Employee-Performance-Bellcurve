package com.performance.appraisal.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Appraisal {

    @Id
    private String employeeId;
    private String category; // A, B, C, D, E
    private double appraisalAmount;

    // Getters and Setters
    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getAppraisalAmount() {
        return appraisalAmount;
    }

    public void setAppraisalAmount(double appraisalAmount) {
        this.appraisalAmount = appraisalAmount;
    }
}

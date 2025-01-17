package com.performance.appraisal.repository;

import com.performance.appraisal.model.RatingCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingCategoryRepository extends JpaRepository<RatingCategory, String> {
}

package com.carpool.smart_carpool.repository;

import com.carpool.smart_carpool.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating, Long> {
}

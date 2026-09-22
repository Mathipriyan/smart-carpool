package com.carpool.smart_carpool.repository;

import com.carpool.smart_carpool.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

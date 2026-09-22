package com.carpool.smart_carpool.service;

import com.carpool.smart_carpool.entity.User;
import com.carpool.smart_carpool.factory.EntityFactory;
import com.carpool.smart_carpool.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EntityFactory entityFactory;

    public User registerUser(String name, String email, String phone, User.Role role) {
        User user = entityFactory.createUser(name, email, phone, role);
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }
}

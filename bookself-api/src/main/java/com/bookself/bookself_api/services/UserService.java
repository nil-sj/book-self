package com.bookself.bookself_api.services;

import com.bookself.bookself_api.dto.BookDto;
import com.bookself.bookself_api.dto.UserDto;
import com.bookself.bookself_api.mappers.BookMapper;
import com.bookself.bookself_api.models.Book;
import com.bookself.bookself_api.models.User;
import com.bookself.bookself_api.models.UserRole;
import com.bookself.bookself_api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Create a new user
    public User createUser(User user) {
        if (emailExists(user.getEmail())) {
            throw new IllegalArgumentException("Email is already in use.");
        }
        if (user.getRole() == null) {
            user.setRole(UserRole.USER);
        }
        return userRepository.save(user);
    }

    // Check if an email exists
    public boolean emailExists(String email) {
        return userRepository.existByEmail(email);
    }

    // Find a user by email
    public Optional<User> findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // Find a user by ID
    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    // Update user details
    public User updateUser(Long userId, User updatedUser) {
        Optional<User> existingUserOptional = userRepository.findById(userId);
        if (existingUserOptional.isEmpty()) {
            throw new IllegalArgumentException("User not found.");
        }

        User existingUser = existingUserOptional.get();
        existingUser.setName(updatedUser.getName());
        existingUser.setBio(updatedUser.getBio());
        existingUser.setProfilePhotoUrl(updatedUser.getProfilePhotoUrl());
        // Add other fields to update if needed
        return userRepository.save(existingUser);
    }

    // Delete a user by ID
    public void deleteUserById(Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new IllegalArgumentException("User not found.");
        }
        userRepository.deleteById(userId);
    }

    public List<User> getAllUsers() {
       return userRepository.findAll();
    }

    public boolean checkPassword (User user, String rawPassword) {
        return passwordEncoder.matches(rawPassword, user.getPassword());
    }
}

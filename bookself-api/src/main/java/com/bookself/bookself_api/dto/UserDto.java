package com.bookself.bookself_api.dto;

import java.time.LocalDateTime;

public class UserDto {
    private Long id;
    private String email;
    private String name;
    private String bio;
    private String profilePhotoUrl;
    private String role; // Represented as a string
    private LocalDateTime createdAt;

    // Constructors
    public UserDto() {}

    public UserDto(Long id, String email, String name, String bio, String profilePhotoUrl, String role, LocalDateTime createdAt) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.bio = bio;
        this.profilePhotoUrl = profilePhotoUrl;
        this.role = role;
        this.createdAt = createdAt;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getProfilePhotoUrl() {
        return profilePhotoUrl;
    }

    public void setProfilePhotoUrl(String profilePhotoUrl) {
        this.profilePhotoUrl = profilePhotoUrl;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}

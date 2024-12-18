package com.bookself.bookself_api.mappers;

import com.bookself.bookself_api.dto.UserDto;
import com.bookself.bookself_api.models.User;

public class UserMapper {
    // Convert User entity to UserDto
    public static UserDto toDto(User user) {
        if (user == null) {
            return null;
        }

        return new UserDto(
                user.getId(),
                user.getEmail(),
                user.getName(),
                user.getBio(),
                user.getProfilePhotoUrl(),
                user.getRole().toString(),
                user.getCreatedAt()
        );
    }

    // Convert UserDto to User entity (for update purposes)
    public static User toEntity(UserDto userDto) {
        if (userDto == null) {
            return null;
        }

        User user = new User();
        user.setId(userDto.getId()); // For updates
        user.setEmail(userDto.getEmail());
        user.setName(userDto.getName());
        user.setBio(userDto.getBio());
        user.setProfilePhotoUrl(userDto.getProfilePhotoUrl());
        // Role should be set explicitly where needed
        return user;
    }
}

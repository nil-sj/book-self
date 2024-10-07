package com.bookself.bookself_api.repositories;

import com.bookself.bookself_api.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    //Method to find user by email
    Optional<User> findByEmail(String email);

    //Method to check email exists
    boolean existByEmail(String email);
}

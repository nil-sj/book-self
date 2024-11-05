package com.bookself.bookself_api.repositories;

import com.bookself.bookself_api.models.Book;
import com.bookself.bookself_api.models.Review;
import com.bookself.bookself_api.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface ReviewRepository extends JpaRepository<Review, Long> {
    // Find all reviews for a specific book
    List<Review> findByBook(Book book);

    // Find all reviews by a specific user
    List<Review> findByUser(User user);

    // Find a specific review by user and book
    Optional<Review> findByUserAndBook(User user, Book book);
}

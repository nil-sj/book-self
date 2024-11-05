package com.bookself.bookself_api.repositories;

import com.bookself.bookself_api.models.ReadingProgress;
import com.bookself.bookself_api.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

@Repository
public interface ReadingProgressRepository extends JpaRepository<ReadingProgress, Long> {

    // Find reading progress by user and book
    Optional<ReadingProgress> findByUserAndBook(User user, Book book);

    // Find all reading progress records for a specific user
    List<ReadingProgress> findByUser(User user);

    // Find all reading progress records for a specific book
    List<ReadingProgress> findByBook(Book book);
}

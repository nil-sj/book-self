package com.bookself.bookself_api.repositories;


import com.bookself.bookself_api.models.BookStatistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookself.bookself_api.models.Book;
import java.util.Optional;

@Repository
public interface BookStatisticsRepository extends JpaRepository<BookStatistics, Long> {

    // Find book statistics by book
    Optional<BookStatistics> findByBook(Book book);

    // Find book statics by book ID
    Optional<BookStatistics> findByBookId(Long bookId);
}

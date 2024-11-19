package com.bookself.bookself_api.services;

import com.bookself.bookself_api.models.Book;
import com.bookself.bookself_api.models.BookStatistics;
import com.bookself.bookself_api.repositories.BookStatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookStaticsService {

    private final BookStatisticsRepository bookStatisticsRepository;

    @Autowired
    public BookStaticsService(BookStatisticsRepository bookStatisticsRepository){
        this.bookStatisticsRepository = bookStatisticsRepository;
    }

    // Find BookStatics by Book ID
    public Optional<BookStatistics> getBookStatistics(Long bookId) {
        return bookStatisticsRepository.findByBookId(bookId);
    }

    // Create a BookStatics
    public BookStatistics createBookStatistics(Book book) {
        BookStatistics bookStatistics = new BookStatistics();
        bookStatistics.setBook(book);
        bookStatistics.setTimesRead(0);  // Initialize to zero
        bookStatistics.setAverageRating(0.0);  // Initialize with a default average rating
        bookStatistics.setTotalReviews(0);  // Initialize with no reviews
        return bookStatisticsRepository.save(bookStatistics);
    }

    // Update a BookStatics



}

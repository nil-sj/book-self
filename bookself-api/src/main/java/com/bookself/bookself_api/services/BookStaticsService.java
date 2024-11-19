package com.bookself.bookself_api.services;

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

}

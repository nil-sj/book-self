package com.bookself.bookself_api.controllers;

import com.bookself.bookself_api.models.BookStatistics;
import com.bookself.bookself_api.repositories.BookStatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/book-statistics")
public class BookStatisticsController {
    @Autowired
    private BookStatisticsRepository bookStatisticsRepository;

    // Get all book statistics
    @GetMapping
    public List<BookStatistics> getAllBookStatistics() {
        return bookStatisticsRepository.findAll();
    }

    // Get statistics by ID
    @GetMapping("/{id}")
    public ResponseEntity<BookStatistics> getBookStatisticsById(@PathVariable Long id) {
        Optional<BookStatistics> bookStatistics = bookStatisticsRepository.findById(id);
        return bookStatistics.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Get statistics by Book ID
    @GetMapping("/book/{bookId}")
    public ResponseEntity<BookStatistics> getBookStatisticsByBookId(@PathVariable Long bookId) {
        Optional<BookStatistics> bookStatistics = bookStatisticsRepository.findByBookId(bookId);
        return bookStatistics.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create new book statistics
    @PostMapping
    public ResponseEntity<BookStatistics> createBookStatistics(@RequestBody BookStatistics bookStatistics) {
        if (bookStatisticsRepository.findByBookId(bookStatistics.getBook().getId()).isPresent()) {
            return ResponseEntity.badRequest().body(null); // Book already has statistics
        }
        BookStatistics savedStatistics = bookStatisticsRepository.save(bookStatistics);
        return ResponseEntity.ok(savedStatistics);
    }

    // Update book statistics
    @PutMapping("/{id}")
    public ResponseEntity<BookStatistics> updateBookStatistics(@PathVariable Long id, @RequestBody BookStatistics updatedStatistics) {
        return bookStatisticsRepository.findById(id)
                .map(existingStatistics -> {
                    existingStatistics.setTimesRead(updatedStatistics.getTimesRead());
                    existingStatistics.setAverageRating(updatedStatistics.getAverageRating());
                    existingStatistics.setTotalReviews(updatedStatistics.getTotalReviews());
                    BookStatistics savedStatistics = bookStatisticsRepository.save(existingStatistics);
                    return ResponseEntity.ok(savedStatistics);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete book statistics
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookStatistics(@PathVariable Long id) {
        if (bookStatisticsRepository.existsById(id)) {
            bookStatisticsRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

package com.bookself.bookself_api.mappers;


import com.bookself.bookself_api.dto.BookStatisticsDto;
import com.bookself.bookself_api.models.BookStatistics;

public class BookStatisticsMapper {
    public static BookStatisticsDto toDto(BookStatistics bookStatistics) {
        BookStatisticsDto dto = new BookStatisticsDto();
        dto.setId(bookStatistics.getId());
        dto.setBookId(bookStatistics.getBook().getId());
        dto.setTimesRead(bookStatistics.getTimesRead());
        dto.setAverageRating(bookStatistics.getAverageRating());
        dto.setTotalReviews(bookStatistics.getTotalReviews());
        dto.setCreatedAt(bookStatistics.getCreatedAt());
        dto.setUpdatedAt(bookStatistics.getUpdatedAt());
        return dto;
    }

    public static BookStatistics toEntity(BookStatisticsDto dto) {
        BookStatistics bookStatistics = new BookStatistics();
        bookStatistics.setId(dto.getId());
        // Note: Setting the Book entity would require fetching the Book by ID separately
        bookStatistics.setTimesRead(dto.getTimesRead());
        bookStatistics.setAverageRating(dto.getAverageRating());
        bookStatistics.setTotalReviews(dto.getTotalReviews());
        return bookStatistics;
    }
}

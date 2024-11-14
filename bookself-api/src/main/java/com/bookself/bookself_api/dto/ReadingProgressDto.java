package com.bookself.bookself_api.dto;

import com.bookself.bookself_api.models.ReadingStatus;

import java.time.LocalDateTime;

public class ReadingProgressDto {
    private Long id;
    private Long userId;
    private Long bookId;
    private int pagesRead;
    private int totalPages;
    private double progressPercentage;
    private LocalDateTime startedDate;
    private LocalDateTime updatedDate;
    private ReadingStatus readingStatus;

    // Constructors
    public ReadingProgressDto() {
    }

    public ReadingProgressDto(Long id, Long userId, Long bookId, int pagesRead, int totalPages, double progressPercentage, LocalDateTime startedDate, LocalDateTime updatedDate, ReadingStatus readingStatus) {
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
        this.pagesRead = pagesRead;
        this.totalPages = totalPages;
        this.progressPercentage = progressPercentage;
        this.startedDate = startedDate;
        this.updatedDate = updatedDate;
        this.readingStatus = readingStatus;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public int getPagesRead() {
        return pagesRead;
    }

    public void setPagesRead(int pagesRead) {
        this.pagesRead = pagesRead;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public double getProgressPercentage() {
        return progressPercentage;
    }

    public void setProgressPercentage(double progressPercentage) {
        this.progressPercentage = progressPercentage;
    }

    public LocalDateTime getStartedDate() {
        return startedDate;
    }

    public void setStartedDate(LocalDateTime startedDate) {
        this.startedDate = startedDate;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

    public ReadingStatus getReadingStatus() {
        return readingStatus;
    }

    public void setReadingStatus(ReadingStatus readingStatus) {
        this.readingStatus = readingStatus;
    }
}

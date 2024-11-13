package com.bookself.bookself_api.dto;

import com.bookself.bookself_api.models.Genre;
import com.bookself.bookself_api.models.Review;
import com.bookself.bookself_api.models.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

public class BookDto {

    private Long id;
    private String title;
    private String author;
    private String description;
    private String isbn;
    private LocalDate publishDate;
    private String coverImagePath;
    private Set<Genre> genres;
    private Set<Review> reviews;
    private User addedBy;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Constructors
    public BookDto() {
    }

    public BookDto(Long id, String title, String author, String description, String isbn, LocalDate publishDate, String coverImagePath, Set<Genre> genres, Set<Review> reviews, User addedBy, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.description = description;
        this.isbn = isbn;
        this.publishDate = publishDate;
        this.coverImagePath = coverImagePath;
        this.genres = genres;
        this.reviews = reviews;
        this.addedBy = addedBy;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    public String getCoverImagePath() {
        return coverImagePath;
    }

    public void setCoverImagePath(String coverImagePath) {
        this.coverImagePath = coverImagePath;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }

    public User getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(User addedBy) {
        this.addedBy = addedBy;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}

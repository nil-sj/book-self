package com.bookself.bookself_api.mappers;

import com.bookself.bookself_api.dto.ReviewDto;
import com.bookself.bookself_api.models.Review;

public class ReviewMapper {
    public static ReviewDto toDto(Review review) {
        ReviewDto dto = new ReviewDto();
        dto.setId(review.getId());
        dto.setUserId(review.getUser().getId());
        dto.setBookId(review.getBook().getId());
        dto.setContent(review.getContent());
        dto.setRating(review.getRating());
        dto.setCreatedDate(review.getCreatedDate());
        dto.setUpdatedDate(review.getUpdatedDate());
        return dto;
    }

    public static Review toEntity(ReviewDto dto) {
        Review review = new Review();
        review.setId(dto.getId());
        // Note: Book and User should be fetched separately and set here if necessary
        review.setContent(dto.getContent());
        review.setRating(dto.getRating());
        review.setCreatedDate(dto.getCreatedDate());
        review.setUpdatedDate(dto.getUpdatedDate());
        return review;
    }
}

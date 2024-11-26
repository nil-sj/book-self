package com.bookself.bookself_api.services;

import com.bookself.bookself_api.models.Review;
import com.bookself.bookself_api.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    // Create or Update Review
    public Review saveReview(Review review) {
        return reviewRepository.save(review);
    }

    // Get Review by ID
    public Optional<Review> getReviewById(Long id) {
        return reviewRepository.findById(id);
    }

    // Get all Reviews for a specific Book
    public List<Review> getReviewsByBookId(Long bookId) {
        return reviewRepository.findAll(); // You can implement a custom query in the repository to filter by bookId
    }

    // Get all Reviews for a specific User
    public List<Review> getReviewsByUserId(Long userId) {
        return reviewRepository.findAll(); // You can implement a custom query in the repository to filter by userId
    }

    // Delete Review by ID
    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }

    // Update the content and rating of an existing Review
    public Review updateReview(Long id, String content, int rating) {
        Optional<Review> reviewOpt = reviewRepository.findById(id);
        if (reviewOpt.isPresent()) {
            Review review = reviewOpt.get();
            review.setContent(content);
            review.setRating(rating);
            return reviewRepository.save(review);
        }
        return null; // Or throw an exception if review not found
    }

}

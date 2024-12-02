package com.bookself.bookself_api.controllers;

import com.bookself.bookself_api.models.Review;
import com.bookself.bookself_api.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    // Create or Update Review
    @PostMapping
    public ResponseEntity<Review> saveReview(@RequestBody Review review){
        Review savedReview = reviewService.saveReview(review);
        return new ResponseEntity<>(savedReview, HttpStatus.CREATED);
    }

    // Get Review by ID
    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long id){
        Optional<Review> reviewOPt = reviewService.getReviewById(id);
        return reviewOPt.map(review -> new ResponseEntity<>(review, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}

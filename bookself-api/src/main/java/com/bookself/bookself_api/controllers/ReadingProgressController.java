package com.bookself.bookself_api.controllers;

import com.bookself.bookself_api.models.ReadingProgress;
import com.bookself.bookself_api.models.User;
import com.bookself.bookself_api.services.ReadingProgressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reading-progress")
public class ReadingProgressController {

    private final ReadingProgressService readingProgressService;

    @Autowired
    public ReadingProgressController(ReadingProgressService readingProgressService) {
        this.readingProgressService = readingProgressService;
    }

    // Get all reading progress records by user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ReadingProgress>> getAllProgressByUser(@PathVariable Long userId) {
        User user = new User();  // Assuming user with the provided ID exists
        user.setId(userId); // You might want to fetch user from the database
        List<ReadingProgress> progressList = readingProgressService.getAllProgressByUser(user);
        return new ResponseEntity<>(progressList, HttpStatus.OK);
    }

    // Create or update reading progress for a user
    @PostMapping
    public ResponseEntity<ReadingProgress> saveOrUpdateReadingProgress(@RequestBody ReadingProgress readingProgress) {
        ReadingProgress savedProgress = readingProgressService.saveOrUpdateReadingProgress(readingProgress);
        return new ResponseEntity<>(savedProgress, HttpStatus.CREATED);
    }

    // Delete a reading progress entry by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReadingProgress(@PathVariable Long id) {
        readingProgressService.deleteProgress(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

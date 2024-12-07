package com.bookself.bookself_api.controllers;

import com.bookself.bookself_api.models.Genre;
import com.bookself.bookself_api.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/genres")
public class GenereController {
    @Autowired
    private GenreRepository genreRepository;

    // Get all genres
    @GetMapping
    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    // Get a genre by ID
    @GetMapping("/{id}")
    public ResponseEntity<Genre> getGenreById(@PathVariable Long id) {
        Optional<Genre> genre = genreRepository.findById(id);
        return genre.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Get a genre by name
    @GetMapping("/name/{name}")
    public ResponseEntity<Genre> getGenreByName(@PathVariable String name) {
        Optional<Genre> genre = genreRepository.findByName(name);
        return genre.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Get genres by category
    @GetMapping("/category/{category}")
    public List<Genre> getGenresByCategory(@PathVariable String category) {
        return genreRepository.findByCategory(category);
    }

    // Create a new genre
    @PostMapping
    public ResponseEntity<Genre> createGenre(@RequestBody Genre genre) {
        if (genreRepository.findByName(genre.getName()).isPresent()) {
            return ResponseEntity.badRequest().body(null); // Genre name must be unique
        }
        Genre savedGenre = genreRepository.save(genre);
        return ResponseEntity.ok(savedGenre);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Genre> updateGenre(@PathVariable Long id, @RequestBody Genre updatedGenre) {
        Optional<Genre> optionalGenre = genreRepository.findById(id);

        if (optionalGenre.isPresent()) {
            Genre existingGenre = optionalGenre.get();
            existingGenre.setName(updatedGenre.getName());
            existingGenre.setDefinition(updatedGenre.getDefinition());
            existingGenre.setCategory(updatedGenre.getCategory());
            Genre savedGenre = genreRepository.save(existingGenre);
            return ResponseEntity.ok(savedGenre);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a genre
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGenre(@PathVariable Long id) {
        if (genreRepository.existsById(id)) {
            genreRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}

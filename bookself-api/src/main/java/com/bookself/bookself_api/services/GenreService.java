package com.bookself.bookself_api.services;

import com.bookself.bookself_api.models.Genre;
import com.bookself.bookself_api.repositories.GenreRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreService {
    private final GenreRepository genreRepository;

    @Autowired
    public GenreService(GenreRepository genreRepository){
        this.genreRepository = genreRepository;
    }

    // Find All Genres
    public List<Genre> getAllGenres(){
        return genreRepository.findAll();
    }

    // Find a Genre by ID
    public Optional<Genre> getGenreById(Long id) {
        return genreRepository.findById(id);
    }

    // Create a new Genre
    public Genre saveGenre(Genre genre) {
        return genreRepository.save(genre);
    }

    // Update an existing Genre
    @Transactional
    public Genre updateBook(Long id, Genre updatedGenre){
        return genreRepository.findById(id).map(genre -> {
            genre.setId(updatedGenre.getId());
            genre.setName(updatedGenre.getName());
            genre.setDefinition(updatedGenre.getDefinition());
            genre.setCategory(updatedGenre.getCategory());
           return genreRepository.save(genre);
        }).orElseThrow(() -> new RuntimeException("Genre not found with id: "+id));
    }

    // Delete Genre by ID
    public void deleteGenre(Long id) {
        if(genreRepository.existsById(id)) {
            genreRepository.deleteById(id);
        }
        else {
            throw new RuntimeException("Genre not found with id: "+id);
        }
    }

    // Find Genre by Name (unique constraint)
    public Optional<Genre> getGenreByName(String name) {
        return genreRepository.findByName(name);
    }

    // Find Genres by Category
    public List<Genre> getGenresByCategory(String category) {
        return genreRepository.findByCategory(category);
    }
}

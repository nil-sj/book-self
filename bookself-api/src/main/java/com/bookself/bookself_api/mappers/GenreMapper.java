package com.bookself.bookself_api.mappers;

import com.bookself.bookself_api.dto.GenreDTO;
import com.bookself.bookself_api.models.Genre;
import com.bookself.bookself_api.models.GenreCategory;

public class GenreMapper {
    public static GenreDTO toDto(Genre genre) {
        if (genre == null) {
            return null;
        }
        return new GenreDTO(
                genre.getId(),
                genre.getName(),
                genre.getDefinition(),
                genre.getCategory().name(),
                genre.getCategoryDisplayName()
        );
    }

    // Convert GenreDTO to Genre entity
    public static Genre toEntity(GenreDTO genreDTO) {
        if (genreDTO == null) {
            return null;
        }
        Genre genre = new Genre();
        genre.setId(genreDTO.getId());
        genre.setName(genreDTO.getName());
        genre.setDefinition(genreDTO.getDefinition());
        genre.setCategory(GenreCategory.valueOf(genreDTO.getCategory()));
        return genre;
    }
}

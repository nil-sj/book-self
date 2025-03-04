package com.bookself.bookself_api.repositories;

import com.bookself.bookself_api.models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {

    //custom query method to find genre by name
    Optional<Genre> findByName(String name);

    // custom query method to find genre by category
    List<Genre> findByCategory(String category);
}

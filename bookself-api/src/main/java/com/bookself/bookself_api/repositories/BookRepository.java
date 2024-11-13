package com.bookself.bookself_api.repositories;

import com.bookself.bookself_api.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findBooksByGenres_IdIn(Set<Long> genreIds);

    List<Book> findByAuthorContainingIgnoreCase(String author);
}

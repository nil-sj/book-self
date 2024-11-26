package com.bookself.bookself_api.mappers;

import com.bookself.bookself_api.dto.BookDto;
import com.bookself.bookself_api.models.Book;

public class BookMapper {
    // Map Book entity to BookDto
    public static BookDto toDto(Book book) {
        if (book == null) {
            return null;
        }

        return new BookDto(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getDescription(),
                book.getIsbn(),
                book.getPublishDate(),
                book.getCoverImagePath(),
                book.getGenres(),
                book.getReviews(),
                book.getAddedBy(),
                book.getCreatedAt(),
                book.getUpdatedAt()
        );
    }

    // Map BookDto to Book entity
    public static Book toEntity(BookDto bookDto) {
        if (bookDto == null) {
            return null;
        }

        Book book = new Book();
        book.setId(bookDto.getId());
        book.setTitle(bookDto.getTitle());
        book.setAuthor(bookDto.getAuthor());
        book.setDescription(bookDto.getDescription());
        book.setIsbn(bookDto.getIsbn());
        book.setPublishDate(bookDto.getPublishDate());
        book.setCoverImagePath(bookDto.getCoverImagePath());
        book.setGenres(bookDto.getGenres());
        book.setReviews(bookDto.getReviews());
        book.setAddedBy(bookDto.getAddedBy());
        book.setCreatedAt(bookDto.getCreatedAt());
        book.setUpdatedAt(bookDto.getUpdatedAt());
        return book;
    }
}

package com.bookself.bookself_api.controllers;

import com.bookself.bookself_api.dto.BookDto;
import com.bookself.bookself_api.mappers.BookMapper;
import com.bookself.bookself_api.models.Book;
import com.bookself.bookself_api.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // Get all books
    @GetMapping
    public ResponseEntity<List<BookDto>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        List<BookDto> bookDtos = books.stream()
                .map(BookMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(bookDtos);
    }

    // Get a book by ID
    @GetMapping("/{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable Long id) {
        Optional<Book> book = bookService.getBookById(id);
        return book.map(value -> ResponseEntity.ok(BookMapper.toDto(value)))
                .orElse(ResponseEntity.notFound().build());
    }

    // Create a new book
    @PostMapping
    public ResponseEntity<BookDto> createBook(@RequestBody BookDto bookDto) {
        Book book = BookMapper.toEntity(bookDto);
        Book createdBook = bookService.createBook(book);
        return ResponseEntity.ok(BookMapper.toDto(createdBook));
    }

    // Update an existing book
    @PutMapping("/{id}")
    public ResponseEntity<BookDto> updateBook(@PathVariable Long id, @RequestBody BookDto bookDto) {
        Book updatedBook = BookMapper.toEntity(bookDto);
        Book savedBook = bookService.updateBook(id, updatedBook);
        return ResponseEntity.ok(BookMapper.toDto(savedBook));
    }

    // Delete a book by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

    // Get books by a specific genre
    @GetMapping("/genre")
    public ResponseEntity<List<BookDto>> getBooksByGenre(@RequestParam Set<Long> genreIds) {
        List<Book> books = bookService.getBooksByGenre(genreIds);
        List<BookDto> bookDtos = books.stream()
                .map(BookMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(bookDtos);
    }

    // Get books by a specific author
    @GetMapping("/author")
    public ResponseEntity<List<BookDto>> getBooksByAuthor(@RequestParam String author) {
        List<Book> books = bookService.getBooksByAuthor(author);
        List<BookDto> bookDtos = books.stream()
                .map(BookMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(bookDtos);
    }
}

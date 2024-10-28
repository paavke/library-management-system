package com.library.controllers;

import com.library.dtos.BookDTO;
import com.library.entities.Book;
import com.library.mappers.BookMapper;
import com.library.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookMapper bookMapper;

    @GetMapping("/search")
    public List<BookDTO> searchBooks(
            @RequestParam(required = false) String author,
            @RequestParam(required = false) String genre,
            @RequestParam(required = false) Boolean isAvailable) {

        List<Book> books = bookService.searchBooks(author, genre, isAvailable);
        return books.stream().map(bookMapper::toDTO).collect(Collectors.toList());
    }
}

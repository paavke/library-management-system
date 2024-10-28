package com.library.controllers;

import com.library.dtos.AnalyticsDTO;
import com.library.dtos.BookDTO;
import com.library.services.BookService;
import com.library.services.AnalyticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/library")
public class LibraryController {

    @Autowired
    private BookService bookService;

    @Autowired
    private AnalyticsService analyticsService;


    @GetMapping("/books")
    public List<BookDTO> getAvailableBooks() {
        return bookService.getAvailableBooks();
    }


    @GetMapping("/analytics")
    public AnalyticsDTO getLibraryAnalytics() {
        return analyticsService.getLibraryAnalytics();
    }
}

package com.library.services;

import com.library.dtos.BookDTO;
import com.library.mappers.BookMapper;
import com.library.repositories.BookRepository;
import com.library.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookMapper bookMapper;

    public List<BookDTO> getAvailableBooks() {
        List<Book> availableBooks = bookRepository.findByIsLoanedFalse();
        return availableBooks.stream()
                .map(bookMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<Book> searchBooks(String author, String genre, Boolean isAvailable) {
        Specification<Book> spec = Specification.where(null);

        if (author != null) {
            spec = spec.and((root, query, cb) -> cb.like(cb.lower(root.get("author")), "%" + author.toLowerCase() + "%"));
        }
        if (genre != null) {
            spec = spec.and((root, query, cb) -> cb.equal(root.get("genre"), genre));
        }
        if (isAvailable != null) {
            spec = spec.and((root, query, cb) -> cb.equal(root.get("isLoaned"), !isAvailable));
        }

        return bookRepository.findAll(spec);
    }
}

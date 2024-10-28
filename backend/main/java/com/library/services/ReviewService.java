package com.library.services;

import com.library.dtos.ReviewDTO;
import com.library.entities.Book;
import com.library.entities.Review;
import com.library.mappers.ReviewMapper;
import com.library.repositories.BookRepository;
import com.library.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ReviewMapper reviewMapper;

    public ReviewDTO addReview(Long bookId, ReviewDTO reviewDTO) {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Book not found"));
        Review review = reviewMapper.toEntity(reviewDTO);
        review.setBook(book);
        return reviewMapper.toDTO(reviewRepository.save(review));
    }
}

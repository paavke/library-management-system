package com.library.controllers;

import com.library.dtos.ReviewDTO;
import com.library.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping("/{bookId}")
    public ReviewDTO addReview(@PathVariable Long bookId, @RequestBody ReviewDTO reviewDTO) {
        return reviewService.addReview(bookId, reviewDTO);
    }
}

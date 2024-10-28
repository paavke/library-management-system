package com.library.dtos;

import lombok.Data;

@Data
public class ReviewDTO {
    private Long id;
    private Long bookId;
    private String comment;
    private int rating;
}

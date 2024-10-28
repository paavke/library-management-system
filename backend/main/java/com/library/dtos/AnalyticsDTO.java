package com.library.dtos;

import lombok.Data;

import java.util.List;

@Data
public class AnalyticsDTO {
    private int totalBooks;
    private int totalMembers;
    private int booksBorrowedToday;
    private int overdueBooks;
    private List<String> popularGenres;
}

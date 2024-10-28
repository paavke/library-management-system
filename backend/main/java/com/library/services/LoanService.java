package com.library.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanService {

    @Autowired
    private EmailNotificationService emailNotificationService;

    @Autowired
    private NotificationService notificationService;

    public void confirmLoan(String email, String bookTitle) {

        emailNotificationService.sendLoanNotification(email, bookTitle);


        String message = "A new book loan has been processed for " + bookTitle;
        notificationService.notifyUsers(message);
    }

    public void notifyLateReturn(String email, String bookTitle, long daysLate) {

        emailNotificationService.sendLateReturnNotification(email, bookTitle, daysLate);


        String message = "Reminder: The book '" + bookTitle + "' is overdue by " + daysLate + " days.";
        notificationService.notifyUsers(message);
    }
}

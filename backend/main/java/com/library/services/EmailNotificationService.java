package com.library.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailNotificationService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendLoanNotification(String email, String bookTitle) {
        String subject = "Loan Confirmation";
        String message = "You have successfully borrowed the book: " + bookTitle;

        sendEmail(email, subject, message);
    }

    public void sendLateReturnNotification(String email, String bookTitle, long daysLate) {
        String subject = "Late Return Notice";
        String message = "The book '" + bookTitle + "' is " + daysLate + " days overdue.";

        sendEmail(email, subject, message);
    }

    private void sendEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);

        mailSender.send(message);
    }
}

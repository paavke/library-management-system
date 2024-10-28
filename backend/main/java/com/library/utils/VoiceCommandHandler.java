package com.library.utils;

import org.springframework.stereotype.Component;

@Component
public class VoiceCommandHandler {

    public String handleCommand(String command) {
        switch (command.toLowerCase()) {
            case "search book":
                return "Please say the book title";
            case "check my loans":
                return "Fetching your loan details";
            case "reserve a book":
                return "Please say the book title to reserve";
            case "view leaderboards":
                return "Displaying the top readers";
            default:
                return "Sorry, I didn't understand that command.";
        }
    }
}

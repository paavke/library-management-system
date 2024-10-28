package com.library.controllers;

import com.library.entities.Badge;
import com.library.services.BadgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/badges")
public class BadgeController {

    @Autowired
    private BadgeService badgeService;

    @GetMapping("/user/{userId}")
    public List<Badge> getUserBadges(@PathVariable Long userId) {
        return (List<Badge>) badgeService.getBadgesByUserId(userId);
    }
}

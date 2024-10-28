package com.library.controllers;

import com.library.dtos.AnalyticsDTO;
import com.library.services.AnalyticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/analytics")
public class AnalyticsController {

    @Autowired
    private AnalyticsService analyticsService;

    @GetMapping("/summary")
    public AnalyticsDTO getAnalyticsSummary() {
        return analyticsService.getLibraryAnalytics();
    }
}

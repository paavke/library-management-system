package com.library.services;

import com.library.dtos.AnalyticsDTO;
import com.library.repositories.AnalyticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnalyticsService {

    @Autowired
    private AnalyticsRepository analyticsRepository;

    public AnalyticsDTO getLibraryAnalytics() {

        return analyticsRepository.generateAnalyticsSummary();
    }
}

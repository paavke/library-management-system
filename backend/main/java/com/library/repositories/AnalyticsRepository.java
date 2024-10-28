package com.library.repositories;

import com.library.dtos.AnalyticsDTO;
import org.springframework.stereotype.Repository;

@Repository
public interface AnalyticsRepository {

    AnalyticsDTO generateAnalyticsSummary();
}

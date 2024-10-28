import React, { useEffect, useState } from 'react';
import analyticsService from '../services/analyticsService';

function AnalyticsDashboard() {
    const [analytics, setAnalytics] = useState(null);

    useEffect(() => {
        analyticsService.getAnalytics().then(data => setAnalytics(data));
    }, []);

    return (
        <div className="p-6 bg-white rounded-lg shadow-lg">
            <h2 className="text-xl font-semibold mb-4">Library Analytics Dashboard</h2>
            {analytics ? (
                <div className="grid grid-cols-2 gap-4">
                    <p>Total Books: {analytics.totalBooks}</p>
                    <p>Total Members: {analytics.totalMembers}</p>
                    <p>Books Borrowed Today: {analytics.booksBorrowedToday}</p>
                    <p>Overdue Books: {analytics.overdueBooks}</p>
                    <div>
                        <h3 className="font-semibold">Popular Genres:</h3>
                        <ul className="list-disc pl-5">
                            {analytics.popularGenres.map((genre, index) => (
                                <li key={index}>{genre}</li>
                            ))}
                        </ul>
                    </div>
                </div>
            ) : (
                <p>Loading analytics...</p>
            )}
        </div>
    );
}

export default AnalyticsDashboard;

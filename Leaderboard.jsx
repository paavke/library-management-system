import React, { useEffect, useState } from 'react';
import leaderboardService from '../services/leaderboardService';

function Leaderboard() {
    const [leaders, setLeaders] = useState([]);

    useEffect(() => {
        leaderboardService.getLeaderboard().then(data => setLeaders(data));
    }, []);

    return (
        <div className="p-6 bg-white rounded-lg shadow-lg">
            <h2 className="text-xl font-semibold mb-4">Top Readers</h2>
            <ul className="list-decimal pl-5">
                {leaders.map((leader, index) => (
                    <li key={index} className="mb-2">{leader.name} - {leader.points} points</li>
                ))}
            </ul>
        </div>
    );
}

export default Leaderboard;

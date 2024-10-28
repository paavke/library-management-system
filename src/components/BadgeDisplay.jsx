import React, { useEffect, useState } from 'react';

function BadgeDisplay({ userId }) {
    const [badges, setBadges] = useState([]);

    useEffect(() => {

        const fetchBadges = async () => {
            try {
                const response = await fetch(`/api/badges/user/${userId}`);
                const data = await response.json();
                setBadges(data);
            } catch (error) {
                console.error("Error fetching badges:", error);
            }
        };

        fetchBadges();
    }, [userId]);

    return (
        <div className="badge-display p-4">
            <h2 className="text-xl font-bold mb-4">User Badges</h2>
            <div className="grid grid-cols-3 gap-4">
                {badges.length > 0 ? (
                    badges.map((badge, index) => (
                        <div key={index} className="badge-item bg-blue-100 p-3 rounded-lg shadow-lg text-center">
                            <h3 className="text-lg font-semibold">{badge.name}</h3>
                            <p className="text-sm text-gray-600">{badge.description}</p>
                        </div>
                    ))
                ) : (
                    <p className="text-gray-500">No badges earned yet.</p>
                )}
            </div>
        </div>
    );
}

export default BadgeDisplay;

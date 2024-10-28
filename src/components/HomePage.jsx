import React from 'react';
import { Link } from 'react-router-dom';

function HomePage() {
    return (
        <div className="homepage p-6 text-center">
            <h1 className="text-4xl font-bold mb-6">Welcome to the Library Management System</h1>
            <div className="grid grid-cols-2 gap-6">
                <Link to="/analytics" className="bg-blue-500 text-white p-4 rounded-lg shadow-md hover:bg-blue-700">
                    Library Analytics
                </Link>
                <Link to="/badges" className="bg-green-500 text-white p-4 rounded-lg shadow-md hover:bg-green-700">
                    User Badges
                </Link>
                <Link to="/reservation" className="bg-purple-500 text-white p-4 rounded-lg shadow-md hover:bg-purple-700">
                    Book Reservation
                </Link>
                <Link to="/qrcode" className="bg-red-500 text-white p-4 rounded-lg shadow-md hover:bg-red-700">
                    QR Code Scanner
                </Link>
                <Link to="/leaderboard" className="bg-yellow-500 text-white p-4 rounded-lg shadow-md hover:bg-yellow-700">
                    Leaderboard
                </Link>
                <Link to="/voice" className="bg-indigo-500 text-white p-4 rounded-lg shadow-md hover:bg-indigo-700">
                    Voice Command
                </Link>
            </div>
        </div>
    );
}

export default HomePage;

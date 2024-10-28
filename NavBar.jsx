import React from 'react';
import { Link } from 'react-router-dom';

function NavBar() {
    return (
        <nav className="navbar bg-gray-800 p-4 text-white">
            <div className="container mx-auto flex justify-between">
                <Link to="/" className="font-bold text-lg">Library System</Link>
                <div className="space-x-4">
                    <Link to="/analytics" className="hover:underline">Analytics</Link>
                    <Link to="/badges" className="hover:underline">Badges</Link>
                    <Link to="/reservation" className="hover:underline">Reservation</Link>
                    <Link to="/qrcode" className="hover:underline">QR Code</Link>
                    <Link to="/leaderboard" className="hover:underline">Leaderboard</Link>
                    <Link to="/voice" className="hover:underline">Voice Command</Link>
                </div>
            </div>
        </nav>
    );
}

export default NavBar;

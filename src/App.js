import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import HomePage from './components/HomePage';
import AnalyticsDashboard from './components/AnalyticsDashboard';
import BadgeDisplay from './components/BadgeDisplay';
import BookReservation from './components/BookReservation';
import QRCodeScanner from './components/QRCodeScanner';
import Leaderboard from './components/Leaderboard';
import VoiceCommand from './components/VoiceCommand';
import NavBar from './components/NavBar';

function App() {
    return (
        <Router>
            <NavBar />
            <Routes>
                <Route path="/" element={<HomePage />} />
                <Route path="/analytics" element={<AnalyticsDashboard />} />
                <Route path="/badges" element={<BadgeDisplay />} />
                <Route path="/reservation" element={<BookReservation />} />
                <Route path="/qrcode" element={<QRCodeScanner />} />
                <Route path="/leaderboard" element={<Leaderboard />} />
                <Route path="/voice" element={<VoiceCommand />} />
            </Routes>
        </Router>
    );
}

export default App;

import React, { useState, useEffect } from 'react';
import reservationService from '../services/reservationService';

function BookReservation({ memberId }) {
    const [reservations, setReservations] = useState([]);
    const [bookId, setBookId] = useState("");

    useEffect(() => {
        loadReservations();
    }, []);

    const loadReservations = async () => {
        const res = await reservationService.getReservationsForMember(memberId);
        setReservations(res);
    };

    const createReservation = async () => {
        await reservationService.createReservation(memberId, bookId);
        loadReservations();
    };

    return (
        <div className="p-6 bg-white rounded-lg shadow-lg">
            <h2 className="text-xl font-semibold mb-4">Book Reservation</h2>
            <input
                type="text"
                placeholder="Enter Book ID"
                value={bookId}
                onChange={(e) => setBookId(e.target.value)}
                className="border p-2 rounded mb-4"
            />
            <button onClick={createReservation} className="bg-blue-500 text-white px-4 py-2 rounded">
                Reserve Book
            </button>
            <h3 className="text-lg font-semibold mt-6">Your Reservations</h3>
            <ul>
                {reservations.map((res) => (
                    <li key={res.id} className="py-2">
                        Book ID: {res.bookId}, Reserved on: {res.reservationDate}, Expires on: {res.expirationDate}
                    </li>
                ))}
            </ul>
        </div>
    );
}

export default BookReservation;

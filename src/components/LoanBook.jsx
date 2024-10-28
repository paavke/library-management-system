import React, { useState } from 'react';
import axios from 'axios';

const LoanBook = () => {
    const [bookId, setBookId] = useState('');
    const [memberId, setMemberId] = useState('');
    const [message, setMessage] = useState('');

    const handleLoan = async () => {
        try {
            await axios.post('/api/library/loan', { bookId, memberId });
            setMessage('Book loaned successfully!');
        } catch (error) {
            setMessage('Failed to loan the book.');
        }
    };

    return (
        <div>
            <h2 className="text-2xl font-bold mb-4">Loan a Book</h2>
            <input
                type="text"
                value={bookId}
                onChange={(e) => setBookId(e.target.value)}
                placeholder="Book ID"
                className="border p-2 mb-4"
            />
            <input
                type="text"
                value={memberId}
                onChange={(e) => setMemberId(e.target.value)}
                placeholder="Member ID"
                className="border p-2 mb-4"
            />
            <button
                onClick={handleLoan}
                className="bg-blue-500 text-white px-4 py-2 rounded"
            >
                Loan Book
            </button>
            {message && <p className="mt-4">{message}</p>}
        </div>
    );
};

export default LoanBook;

import axios from 'axios';

const BASE_URL = '/api/reservations';

const createReservation = async (memberId, bookId) => {
    const response = await axios.post(`${BASE_URL}/create`, null, { params: { memberId, bookId } });
    return response.data;
};

const getReservationsForMember = async (memberId) => {
    const response = await axios.get(`${BASE_URL}/member/${memberId}`);
    return response.data;
};

export default { createReservation, getReservationsForMember };

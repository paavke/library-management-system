import axios from 'axios';

const getLeaderboard = async () => {
    const response = await axios.get('/api/badges/leaderboard');
    return response.data;
};

export default { getLeaderboard };

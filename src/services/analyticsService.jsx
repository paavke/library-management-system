import axios from 'axios';

const getAnalytics = async () => {
    const response = await axios.get('/api/analytics/summary');
    return response.data;
};

export default { getAnalytics };

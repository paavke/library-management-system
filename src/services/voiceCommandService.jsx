import axios from 'axios';

const sendVoiceCommand = async (command) => {
    const response = await axios.post('/api/voice/command', { command });
    return response.data;
};

export default { sendVoiceCommand };

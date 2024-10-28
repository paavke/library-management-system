import React, { useState } from 'react';
import voiceCommandService from '../services/voiceCommandService';

function VoiceCommand() {
    const [command, setCommand] = useState('');
    const [response, setResponse] = useState('');
    const [isListening, setIsListening] = useState(false);

    const handleVoiceInput = () => {
        const recognition = new (window.SpeechRecognition || window.webkitSpeechRecognition)();
        recognition.lang = 'en-US';
        recognition.interimResults = false;
        recognition.maxAlternatives = 1;

        recognition.onstart = () => setIsListening(true);

        recognition.onresult = async (event) => {
            const voiceCommand = event.results[0][0].transcript;
            setCommand(voiceCommand);
            setIsListening(false);

            // sending the voice command to the backend
            try {
                const response = await voiceCommandService.sendVoiceCommand(voiceCommand);
                setResponse(response.message);
            } catch (error) {
                setResponse('Error processing command.');
            }
        };

        recognition.onerror = (error) => {
            console.error('Speech recognition error:', error);
            setIsListening(false);
        };

        recognition.onend = () => setIsListening(false);

        recognition.start();
    };

    return (
        <div className="p-6 bg-white rounded-lg shadow-lg">
            <h2 className="text-xl font-semibold mb-4">Voice Command Assistant</h2>
            <button
                onClick={handleVoiceInput}
                disabled={isListening}
                className={`px-4 py-2 text-white rounded ${isListening ? 'bg-gray-500' : 'bg-blue-500 hover:bg-blue-700'}`}
            >
                {isListening ? 'Listening...' : 'Press to Speak'}
            </button>
            <div className="mt-4">
                <p className="text-gray-700">
                    <strong>Command:</strong> {command}
                </p>
                <p className="text-green-700">
                    <strong>Response:</strong> {response}
                </p>
            </div>
        </div>
    );
}

export default VoiceCommand;

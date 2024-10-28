import React, { useRef, useState } from 'react';
import { QrReader } from 'react-qr-reader';

function QRCodeScanner() {
    const [data, setData] = useState('No result');

    return (
        <div className="p-6 bg-white rounded-lg shadow-lg">
            <h2 className="text-xl font-semibold mb-4">QR Code Scanner</h2>
            <QrReader
                onResult={(result, error) => {
                    if (!!result) {
                        setData(result?.text);
                    }
                    if (!!error) {
                        console.info(error);
                    }
                }}
                style={{ width: '100%' }}
            />
            <p className="mt-4 text-gray-700">Scanned Result: {data}</p>
        </div>
    );
}

export default QRCodeScanner;

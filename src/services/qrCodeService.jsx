import axios from 'axios';

const generateQRCodeForBook = async (bookId) => {
    const response = await axios.get(`/api/qrcode/generate?bookId=${bookId}`, {
        responseType: 'blob',
    });
    return response.data;
};

export default { generateQRCodeForBook };

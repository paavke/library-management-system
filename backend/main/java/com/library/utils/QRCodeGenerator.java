package com.library.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.common.BitMatrix;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class QRCodeGenerator {

    public static BufferedImage generateQRCode(String qrCodeText) throws Exception {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(qrCodeText, BarcodeFormat.QR_CODE, 200, 200);

        BufferedImage image = new BufferedImage(200, 200, BufferedImage.TYPE_INT_RGB);
        image.createGraphics();

        Graphics2D graphics = (Graphics2D) image.getGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, 200, 200);
        graphics.setColor(Color.BLACK);

        for (int x = 0; x < 200; x++) {
            for (int y = 0; y < 200; y++) {
                if (bitMatrix.get(x, y)) {
                    graphics.fillRect(x, y, 1, 1);
                }
            }
        }
        return image;
    }
}

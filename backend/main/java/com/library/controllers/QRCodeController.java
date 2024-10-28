package com.library.controllers;

import com.library.services.QRCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;

@RestController
@RequestMapping("/api/qrcode")
public class QRCodeController {

    @Autowired
    private QRCodeService qrCodeService;

    @GetMapping("/generate")
    public void generateQRCodeForBook(@RequestParam String bookId, HttpServletResponse response) throws Exception {
        BufferedImage qrImage = qrCodeService.generateQRCodeForBook(bookId);
        response.setContentType("image/png");
        ImageIO.write(qrImage, "PNG", response.getOutputStream());
    }
}

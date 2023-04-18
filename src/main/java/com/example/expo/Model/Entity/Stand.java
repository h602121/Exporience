package com.example.expo.Model.Entity;

import javax.imageio.ImageIO;
import javax.persistence.*;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.encoder.QRCode;


import java.io.ByteArrayOutputStream;
import java.util.Base64;
import java.util.Objects;
import java.util.Random;
import java.awt.image.BufferedImage;

@Entity
@Table(name = "stand", schema = "exporiencedb")
public class Stand {

    private static final int BLACK = 0xFF000000;
    private static final int WHITE = 0xFFFFFFFF;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "qr_code")
    private Integer qrCode;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "stand_description")
    private String stand_description;

    @Basic
    @Column(name = "active")
    private boolean active = true;

    public Stand() {
    }

    public Stand(String name, String stand_description) {
        this.name = name;
        this.stand_description = stand_description;
        this.qrCode = new Random().nextInt(500);
    }

    public String getStand_description() {
        return stand_description;
    }

    public void setStand_description(String stand_description) {
        this.stand_description = stand_description;
    }

    public Integer getId() {
        return qrCode;
    } 
    
    public Integer getQrCode(){
        return qrCode;
    }

    public void setQrCode(Integer qrCode) {
        this.qrCode = qrCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getIsActive() {
        return active;
    }

    public void setIsActive(boolean isActive) {
        this.active = isActive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stand stand = (Stand) o;
        return Objects.equals(qrCode, stand.qrCode) && Objects.equals(name, stand.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(qrCode, name);
    }

    public String generateQRCodeUrl() {
        String url = "";
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qrCodeWriter.encode("expo-0.0.2/stand/" + getQrCode(), BarcodeFormat.QR_CODE, 250, 250);
            int width = bitMatrix.getWidth();
            int height = bitMatrix.getHeight();
            BufferedImage qrCodeImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    qrCodeImage.setRGB(x, y, bitMatrix.get(x, y) ? BLACK : WHITE);
                }
            }
            ImageIO.write(qrCodeImage, "png", baos);
            baos.flush();
            byte[] imageInByte = baos.toByteArray();
            baos.close();
            String base64Encoded = Base64.getEncoder().encodeToString(imageInByte);
            url = "data:image/png;base64," + base64Encoded;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return url;
    }
    
    
    
}
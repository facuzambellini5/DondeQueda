package com.example.dondeQueda.dtos;

import com.example.dondeQueda.enums.ImageType;
import com.example.dondeQueda.models.Image;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class ImageDto {

    private Long idImage;
    private String url;
    private String originalFileName;
    private String publicId;
    private ImageType imageType;
    private int imageOrder;

    public ImageDto() {
    }

    public ImageDto(Image image) {
        this.idImage = image.getIdImage();
        this.url = image.getUrl();
        this.originalFileName = image.getOriginalFileName();
        this.publicId = image.getPublicId();
        this.imageType = image.getImageType();
        this.imageOrder = image.getImageOrder();
    }

    public Long getIdImage() {
        return idImage;
    }

    public void setIdImage(Long idImage) {
        this.idImage = idImage;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getOriginalFileName() {
        return originalFileName;
    }

    public void setOriginalFileName(String originalFileName) {
        this.originalFileName = originalFileName;
    }

    public String getPublicId() {
        return publicId;
    }

    public void setPublicId(String publicId) {
        this.publicId = publicId;
    }

    public ImageType getImageType() {
        return imageType;
    }

    public void setImageType(ImageType imageType) {
        this.imageType = imageType;
    }

    public int getImageOrder() {
        return imageOrder;
    }

    public void setImageOrder(int imageOrder) {
        this.imageOrder = imageOrder;
    }
}

package com.example.dondeQueda.dtos;

import com.example.dondeQueda.enums.ImageType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class ImageDto {

    private String url;

    @Enumerated(EnumType.STRING)
    private ImageType imageType;

    private Long idEntity;

    public ImageType getImageType() {
        return imageType;
    }

    public void setImageType(ImageType imageType) {
        this.imageType = imageType;
    }

    public Long getIdEntity() {
        return idEntity;
    }

    public void setIdEntity(Long idEntity) {
        this.idEntity = idEntity;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

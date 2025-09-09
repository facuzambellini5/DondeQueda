package com.example.dondeQueda.models;

import com.example.dondeQueda.enums.ImageType;
import jakarta.persistence.*;

@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idImage;

    private String url;

    @Enumerated(EnumType.STRING)
    private ImageType type;


    public Image() {
    }

    public Image(Long idImage, String url, ImageType type) {
        this.idImage = idImage;
        this.url = url;
        this.type = type;
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

    public ImageType getType() {
        return type;
    }

    public void setType(ImageType type) {
        this.type = type;
    }
}

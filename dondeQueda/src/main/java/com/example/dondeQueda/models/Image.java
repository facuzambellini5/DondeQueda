package com.example.dondeQueda.models;

import com.example.dondeQueda.enums.EntityType;
import com.example.dondeQueda.enums.ImageType;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idImage;

    private String url;

    @Column(name = "image_type")
    @Enumerated(EnumType.STRING)
    private ImageType imageType;

    @Column(name = "entity_type")
    @Enumerated(EnumType.STRING)
    private EntityType entityType;

    @Column(name = "image_order")
    private int imageOrder;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public Image() {
    }

    public Image(Long idImage, String url, ImageType imageType, EntityType entityType, int imageOrder, LocalDateTime createdAt) {
        this.idImage = idImage;
        this.url = url;
        this.imageType = imageType;
        this.entityType = entityType;
        this.imageOrder = imageOrder;
        this.createdAt = createdAt;
    }

    public EntityType getEntityType() {
        return entityType;
    }

    public void setEntityType(EntityType entityType) {
        this.entityType = entityType;
    }

    public int getImageOrder() {
        return imageOrder;
    }

    public void setImageOrder(int imageOrder) {
        this.imageOrder = imageOrder;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
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
        return imageType;
    }

    public void setType(ImageType imageType) {
        this.imageType = imageType;
    }
}

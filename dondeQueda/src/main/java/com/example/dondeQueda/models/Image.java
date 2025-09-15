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

    @Column(name = "id_entity")
    private Long idEntity;

    @Column(name = "entity_type")
    @Enumerated(EnumType.STRING)
    private EntityType entityType;

    @Column(name = "image_order")
    private int imageOrder;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public Image() {
    }

    public Image(Long idImage, String url, ImageType imageType, Long idEntity, EntityType entityType, int imageOrder, LocalDateTime createdAt) {
        this.idImage = idImage;
        this.url = url;
        this.imageType = imageType;
        this.idEntity = idEntity;
        this.entityType = entityType;
        this.imageOrder = imageOrder;
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
}



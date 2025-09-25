package com.example.dondeQueda.models;

import com.example.dondeQueda.enums.ImageType;
import jakarta.persistence.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idImage;

    private String url;

    @Column(name = "public_id")
    private String publicId;

    @Column(name = "image_type")
    @Enumerated(EnumType.STRING)
    private ImageType imageType;

    @Column(name = "image_order")
    private int imageOrder;

    @Column(name = "created_at")
    @UpdateTimestamp
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "id_commerce")
    private Commerce commerce;

    @ManyToOne
    @JoinColumn(name = "id_event")
    private Event event;

    @ManyToOne
    @JoinColumn(name = "id_post")
    private Post post;

    public Image() {
    }

    public Image(Long idImage, String url, String publicId, ImageType imageType, int imageOrder, LocalDateTime createdAt, Commerce commerce, Event event, Post post) {
        this.idImage = idImage;
        this.url = url;
        this.publicId = publicId;
        this.imageType = imageType;
        this.imageOrder = imageOrder;
        this.createdAt = createdAt;
        this.commerce = commerce;
        this.event = event;
        this.post = post;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Commerce getCommerce() {
        return commerce;
    }

    public void setCommerce(Commerce commerce) {
        this.commerce = commerce;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}



package com.example.dondeQueda.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPost;

    private String description;

    @Column(name = "posted_at")
    @UpdateTimestamp
    private LocalDateTime postedAt;

    @ManyToOne
    @JoinColumn(name = "id_commerce")
    @JsonIgnore
    private Commerce commerce;

    @ManyToMany(mappedBy = "savedPosts")
    @JsonIgnore
    private List<User> users;

    @OneToMany(mappedBy = "post")
    private List<Image> images;

    public Post() {
    }

    public Post(Long idPost, String description, LocalDateTime postedAt, Commerce commerce, List<User> users, List<Image> images) {
        this.idPost = idPost;
        this.description = description;
        this.postedAt = postedAt;
        this.commerce = commerce;
        this.users = users;
        this.images = images;
    }

    public Long getIdPost() {
        return idPost;
    }

    public void setIdPost(Long idPost) {
        this.idPost = idPost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getPostedAt() {
        return postedAt;
    }

    public void setPostedAt(LocalDateTime postedAt) {
        this.postedAt = postedAt;
    }

    public Commerce getCommerce() {
        return commerce;
    }

    public void setCommerce(Commerce commerce) {
        this.commerce = commerce;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }
}

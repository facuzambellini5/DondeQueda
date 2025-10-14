package com.example.dondeQueda.dtos;

import com.example.dondeQueda.models.Image;
import com.example.dondeQueda.models.Post;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PostResponse {

    private Long idPost;
    private String description;
    private LocalDateTime postedAt;
    private Long idCommerce;
    private String nameCommerce;

    private List<ImageDto> images = new ArrayList<>();

    public PostResponse(Post post) {
        this.idPost = post.getIdPost();
        this.description = post.getDescription();
        this.postedAt = post.getPostedAt();
        this.idCommerce = post.getCommerce().getIdCommerce();
        this.nameCommerce = post.getCommerce().getName();

        for(Image image : post.getImages()){
            ImageDto imageDto = new ImageDto(image);
            this.images.add(imageDto);
        }
        this.images.sort(Comparator.comparing(ImageDto::getImageOrder));
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

    public Long getIdCommerce() {
        return idCommerce;
    }

    public void setIdCommerce(Long idCommerce) {
        this.idCommerce = idCommerce;
    }

    public String getNameCommerce() {
        return nameCommerce;
    }

    public void setNameCommerce(String nameCommerce) {
        this.nameCommerce = nameCommerce;
    }

    public List<ImageDto> getImages() {
        return images;
    }

    public void setImages(List<ImageDto> images) {
        this.images = images;
    }
}

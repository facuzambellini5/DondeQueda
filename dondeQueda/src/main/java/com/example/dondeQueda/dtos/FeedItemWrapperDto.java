package com.example.dondeQueda.dtos;

import com.example.dondeQueda.models.Event;
import com.example.dondeQueda.models.Post;

import java.time.LocalDateTime;

public class FeedItemWrapperDto {

    private String type;
    private Object data;
    private LocalDateTime createdAt;
    private Double relevanceScore;


    public FeedItemWrapperDto(Post post) {
        this.type = "POST";
        this.data = new PostResponseDto(post);
        this.createdAt = post.getPostedAt();
    }

    public FeedItemWrapperDto(Event event) {
        this.type = "EVENT";
        this.data = new EventResponseDto(event);
        this.createdAt = event.getCreatedAt();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Double getRelevanceScore() {
        return relevanceScore;
    }

    public void setRelevanceScore(Double relevanceScore) {
        this.relevanceScore = relevanceScore;
    }
}

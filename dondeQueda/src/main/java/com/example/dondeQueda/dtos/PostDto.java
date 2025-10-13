package com.example.dondeQueda.dtos;

public class PostDto {
    private String title;
    private String description;
    private Long idCommerce;

    public PostDto(String title, String description, Long idCommerce) {
        this.title = title;
        this.description = description;
        this.idCommerce = idCommerce;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Long getIdCommerce() {
        return idCommerce;
    }
}

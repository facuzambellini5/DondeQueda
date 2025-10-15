package com.example.dondeQueda.dtos;

public class PostDto {
    private String description;
    private Long idCommerce;

    public PostDto(String description, Long idCommerce) {
        this.description = description;
        this.idCommerce = idCommerce;
    }

    public String getDescription() {
        return description;
    }

    public Long getIdCommerce() {
        return idCommerce;
    }
}

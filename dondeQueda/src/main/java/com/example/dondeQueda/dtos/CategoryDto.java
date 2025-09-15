package com.example.dondeQueda.dtos;

public class CategoryDto {

    private String name;
    private String description;

    public CategoryDto() {
    }

    public CategoryDto(String name, String description) {
        this.name = name;
        this.description = description;
    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}

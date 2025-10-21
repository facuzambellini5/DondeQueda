package com.example.dondeQueda.dtos;

import com.example.dondeQueda.models.Category;

public class CategoryDto {

    private Long idCategory;
    private String name;
    private String description;

    public CategoryDto() {
    }

    public CategoryDto(Category category) {
        this.idCategory = category.getIdCategory();
        this.name = category.getName();
        this.description = category.getDescription();
    }

    public Long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Long idCategory) {
        this.idCategory = idCategory;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}

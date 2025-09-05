package com.example.dondeQueda.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategory;

    private String name;

    private String description;

    @OneToMany(mappedBy = "category")
    private List<Subcategory> subcategories;

    @ManyToMany(mappedBy = "categories")
    private List<Commerce> commerces;

    public Category() {
    }

    public Category(Long idCategory, String name, String description, List<Subcategory> subcategories, List<Commerce> commerces) {
        this.idCategory = idCategory;
        this.name = name;
        this.description = description;
        this.subcategories = subcategories;
        this.commerces = commerces;
    }

    public Long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Long idCategory) {
        this.idCategory = idCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Subcategory> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(List<Subcategory> subcategories) {
        this.subcategories = subcategories;
    }

    public List<Commerce> getCommerces() {
        return commerces;
    }

    public void setCommerces(List<Commerce> commerces) {
        this.commerces = commerces;
    }
}

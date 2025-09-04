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
}

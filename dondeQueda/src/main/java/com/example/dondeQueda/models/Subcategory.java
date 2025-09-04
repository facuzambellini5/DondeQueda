package com.example.dondeQueda.models;

import jakarta.persistence.*;

@Entity
public class Subcategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSubcategory;

    private String name;

    private String description;

    @ManyToOne
    @JoinColumn(name = "id_category")
    private Category category;

}

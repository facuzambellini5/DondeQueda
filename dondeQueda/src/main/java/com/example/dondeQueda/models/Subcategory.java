package com.example.dondeQueda.models;

import jakarta.persistence.*;

@Entity
public class Subcategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSubcategory;

    private String name;

    private String description;

    //Relacion con Category

}

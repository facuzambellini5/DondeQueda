package com.example.dondeQueda.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTag;

    @Column(name = "name_tag")
    private String nameTag;

    @ManyToMany(mappedBy = "tags")
    private List<Commerce> commerces;

}

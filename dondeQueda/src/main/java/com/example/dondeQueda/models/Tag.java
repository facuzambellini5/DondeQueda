package com.example.dondeQueda.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import java.util.List;

@Entity
public class Tag {

    @Id
    private String nameTag;

    @ManyToMany(mappedBy = "tags")
    private List<Commerce> commerces;

}

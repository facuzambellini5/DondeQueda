package com.example.dondeQueda.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Tag {

    @Id
    private String nameTag;
}

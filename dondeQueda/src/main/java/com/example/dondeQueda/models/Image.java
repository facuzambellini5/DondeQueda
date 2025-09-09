package com.example.dondeQueda.models;

import com.example.dondeQueda.enums.ImageType;
import jakarta.persistence.*;

@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idImage;

    private String url;

    @Enumerated(EnumType.STRING)
    private ImageType type;



}

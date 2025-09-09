package com.example.dondeQueda.dtos;

import com.example.dondeQueda.enums.ImageType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class ImageDto {

    private String url;

    @Enumerated(EnumType.STRING)
    private ImageType type;
}

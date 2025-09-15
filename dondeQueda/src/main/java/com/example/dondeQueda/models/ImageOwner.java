package com.example.dondeQueda.models;

import java.util.List;

public interface ImageOwner {
    String getEntityType();
    List<Image> getImages();
    void setImages(List<Image> images);
}

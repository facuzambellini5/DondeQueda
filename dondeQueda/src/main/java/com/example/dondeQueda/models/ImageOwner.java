package com.example.dondeQueda.models;

import java.util.List;

public interface ImageOwner {
    Long getIdEntity();
    String getEntityType();
    List<Image> getImages();
    void setImages(List<Image> images);
}

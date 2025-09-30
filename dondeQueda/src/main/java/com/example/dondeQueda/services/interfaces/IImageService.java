package com.example.dondeQueda.services.interfaces;

import com.example.dondeQueda.dtos.ImageDto;
import com.example.dondeQueda.models.Image;

import java.util.List;

public interface IImageService {

    void saveImgage(ImageDto imageDto);

    List<Image> getImages();

    Image getImageById(Long idImage);

    void editImage(Long idImage, ImageDto imageDto);

    void deleteImageById(Long idImage);

    List<Image> getImagesByCommerce(Long idCommerce);

    List<Image> getImagesByEvent(Long idEvent);

    List<Image> getImagesByPost(Long idPost);
}

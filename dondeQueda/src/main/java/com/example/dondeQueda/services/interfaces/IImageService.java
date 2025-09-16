package com.example.dondeQueda.services.interfaces;

import com.example.dondeQueda.dtos.ImageDto;
import com.example.dondeQueda.models.Image;
import com.example.dondeQueda.models.ImageOwner;

import java.util.List;

public interface IImageService {

    String saveImgage(ImageDto imageDto);

    List<Image> getImages();

    Image getImageById(Long idImage);

    String editImage(Long idImage, ImageDto imageDto);

    String deleteImageById(Long idImage);

    List<Image> getImages(ImageOwner entity);
}

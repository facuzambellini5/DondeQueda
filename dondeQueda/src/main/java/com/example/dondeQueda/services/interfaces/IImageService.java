package com.example.dondeQueda.services.interfaces;

import com.example.dondeQueda.dtos.ImageDto;
import com.example.dondeQueda.models.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IImageService {

    void uploadImageToPost(Long postId, MultipartFile file) throws IOException;
    void uploadImageToEvent(Long eventId, MultipartFile file) throws IOException;
    void uploadImageToCommerce(Long commerceId, MultipartFile file) throws IOException;


    List<Image> getImages();

    Image getImageById(Long idImage);

    void editImage(Long idImage, ImageDto imageDto);

    void deleteImageById(Long idImage);

    List<Image> getImagesByCommerce(Long idCommerce);

    List<Image> getImagesByEvent(Long idEvent);

    List<Image> getImagesByPost(Long idPost);
}

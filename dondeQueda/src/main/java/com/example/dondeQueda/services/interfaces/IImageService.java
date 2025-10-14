package com.example.dondeQueda.services.interfaces;

import com.example.dondeQueda.models.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IImageService {

    void uploadImageToPost(Long postId, int imageOrder, MultipartFile file) throws IOException;

    void uploadImageToEvent(Long eventId, int imageOrder, MultipartFile file) throws IOException;

    void uploadGalleryImageToCommerce(Long commerceId, int imageOrder, MultipartFile file) throws IOException;

    void setProfileImageToCommerce(Long commerceId, MultipartFile file) throws IOException;

    void setCoverImageToCommerce(Long commerceId, MultipartFile file) throws IOException;


    void deleteImage(Long imageId);

    Image getImageById(Long idImage);

    List<Image> getImagesByCommerce(Long idCommerce);

    List<Image> getImagesByEvent(Long idEvent);

    List<Image> getImagesByPost(Long idPost);
}

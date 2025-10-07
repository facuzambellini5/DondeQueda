package com.example.dondeQueda.services;

import com.example.dondeQueda.dtos.ImageDto;
import com.example.dondeQueda.models.Image;
import com.example.dondeQueda.models.Post;
import com.example.dondeQueda.repositories.IImageRepository;
import com.example.dondeQueda.services.interfaces.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;


@Service
public class ImageService implements IImageService {

    @Autowired
    private IImageRepository imageRepo;
    @Autowired
    private ICommerceService commerceService;
    @Autowired
    private IEventService eventService;
    @Autowired
    private IPostService postService;
    @Autowired
    private ICloudinaryService cloudinaryService;


    @Override
    public void uploadImageToPost(Long postId, MultipartFile file) throws IOException {

        Post post = postService.getPostById(postId);

        Map<String,Object> cloudinaryResult = cloudinaryService.uploadImage(file, "post");
    }

    @Override
    public void uploadImageToEvent(Long eventId, MultipartFile file) throws IOException {

    }

    @Override
    public void uploadImageToCommerce(Long commerceId, MultipartFile file) throws IOException {

    }

    @Override
    public List<Image> getImages() {
        return List.of();
    }

    @Override
    public Image getImageById(Long idImage) {
        return null;
    }

    @Override
    public void editImage(Long idImage, ImageDto imageDto) {

    }

    @Override
    public void deleteImageById(Long idImage) {

    }

    @Override
    public List<Image> getImagesByCommerce(Long idCommerce) {
        return List.of();
    }

    @Override
    public List<Image> getImagesByEvent(Long idEvent) {
        return List.of();
    }

    @Override
    public List<Image> getImagesByPost(Long idPost) {
        return List.of();
    }
}




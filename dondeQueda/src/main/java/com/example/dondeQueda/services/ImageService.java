package com.example.dondeQueda.services;

import com.example.dondeQueda.dtos.ImageDto;
import com.example.dondeQueda.models.Commerce;
import com.example.dondeQueda.models.Event;
import com.example.dondeQueda.models.Image;
import com.example.dondeQueda.models.Post;
import com.example.dondeQueda.repositories.IImageRepository;
import com.example.dondeQueda.services.interfaces.*;

import com.example.dondeQueda.utils.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;


@Service
@Transactional
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

        Image image = new Image();
        image.setUrl((String)cloudinaryResult.get("secure_url"));
        image.setPublicId((String) cloudinaryResult.get("public_id"));
        image.setOriginalFileName(file.getOriginalFilename());
        image.setPost(post);

        imageRepo.save(image);
    }

    @Override
    public void uploadImageToEvent(Long eventId, MultipartFile file) throws IOException {

        Event event = eventService.getEventById(eventId);

        Map<String,Object> cloudinaryResult = cloudinaryService.uploadImage(file, "events");

        Image image = new Image();
        image.setUrl((String)cloudinaryResult.get("secure_url"));
        image.setPublicId((String) cloudinaryResult.get("public_id"));
        image.setOriginalFileName(file.getOriginalFilename());
        image.setEvent(event);

        imageRepo.save(image);
    }

    @Override
    public void uploadImageToCommerce(Long commerceId, MultipartFile file) throws IOException {

        Commerce commerce = commerceService.getCommerceById(commerceId);

        Map<String,Object> cloudinaryResult = cloudinaryService.uploadImage(file, "commerces");

        Image image = new Image();
        image.setUrl((String)cloudinaryResult.get("secure_url"));
        image.setPublicId((String) cloudinaryResult.get("public_id"));
        image.setOriginalFileName(file.getOriginalFilename());
        image.setCommerce(commerce);

        imageRepo.save(image);
    }

    @Override
    public void deleteImage(Long imageId) {

        Image image = this.getImageById(imageId);

        try{
            cloudinaryService.deleteImage(image.getPublicId());
        } catch (Exception e){
        }

        imageRepo.delete(image);
    }

    @Override
    public List<Image> getImages() {
        return List.of();
    }

    @Override
    public Image getImageById(Long idImage) {
        return ValidationUtils.validateEntity(imageRepo.findById(idImage),"Imagen", idImage);
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




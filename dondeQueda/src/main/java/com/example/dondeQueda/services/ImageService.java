package com.example.dondeQueda.services;

import com.example.dondeQueda.dtos.ImageDto;
import com.example.dondeQueda.enums.ImageType;
import com.example.dondeQueda.models.Commerce;
import com.example.dondeQueda.models.Event;
import com.example.dondeQueda.models.Image;
import com.example.dondeQueda.models.Post;
import com.example.dondeQueda.repositories.ICommerceRepository;
import com.example.dondeQueda.repositories.IEventRepository;
import com.example.dondeQueda.repositories.IImageRepository;
import com.example.dondeQueda.repositories.IPostRepository;
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
    private ICommerceRepository commerceRepo;
    @Autowired
    private IEventRepository eventRepo;
    @Autowired
    private IPostRepository postRepo;
    @Autowired
    private ICloudinaryService cloudinaryService;


    @Override
    public void uploadImageToPost(Long postId, int imageOrder, MultipartFile file) throws IOException {

        Post post = ValidationUtils.validateEntity(postRepo.findById(postId), "Publicación", postId);

        Map<String,Object> cloudinaryResult = cloudinaryService.uploadImage(file, "posts");

        Image image = new Image();
        image.setUrl((String)cloudinaryResult.get("secure_url"));
        image.setPublicId((String) cloudinaryResult.get("public_id"));
        image.setOriginalFileName(file.getOriginalFilename());
        image.setPost(post);
        image.setImageOrder(imageOrder);
        image.setImageType(ImageType.GALLERY);

        imageRepo.save(image);
    }

    @Override
    public void uploadImageToEvent(Long eventId, int imageOrder, MultipartFile file) throws IOException {

        Event event = ValidationUtils.validateEntity(eventRepo.findById(eventId),"Evento", eventId);

        Map<String,Object> cloudinaryResult = cloudinaryService.uploadImage(file, "events");

        Image image = new Image();
        image.setUrl((String)cloudinaryResult.get("secure_url"));
        image.setPublicId((String) cloudinaryResult.get("public_id"));
        image.setOriginalFileName(file.getOriginalFilename());
        image.setEvent(event);
        image.setImageOrder(imageOrder);
        image.setImageType(ImageType.GALLERY);

        imageRepo.save(image);
    }

    @Override
    public void uploadGalleryImageToCommerce(Long commerceId, int imageOrder, MultipartFile file) throws IOException {

        Commerce commerce = ValidationUtils.validateEntity(commerceRepo.findById(commerceId),"Comercio", commerceId);

        Map<String,Object> cloudinaryResult = cloudinaryService.uploadImage(file, "commerces/gallery");

        Image image = new Image();
        image.setUrl((String)cloudinaryResult.get("secure_url"));
        image.setPublicId((String) cloudinaryResult.get("public_id"));
        image.setOriginalFileName(file.getOriginalFilename());
        image.setCommerce(commerce);
        image.setImageOrder(imageOrder);
        image.setImageType(ImageType.GALLERY);

        imageRepo.save(image);
    }

    @Override
    public void setProfileImageToCommerce(Long commerceId, MultipartFile file) throws IOException {

        //TODO implementar logica para eliminar la imagen anterior

        Commerce commerce = ValidationUtils.validateEntity(commerceRepo.findById(commerceId),"Comercio", commerceId);

        Map<String,Object> cloudinaryResult = cloudinaryService.uploadImage(file, "commerces/profile");

        Image image = new Image();
        image.setUrl((String)cloudinaryResult.get("secure_url"));
        image.setPublicId((String) cloudinaryResult.get("public_id"));
        image.setOriginalFileName(file.getOriginalFilename());
        image.setCommerce(commerce);
        image.setImageType(ImageType.PROFILE);

        imageRepo.save(image);
    }

    @Override
    public void setCoverImageToCommerce(Long commerceId, MultipartFile file) throws IOException {

        //TODO implementar logica para eliminar la imagen anterior

        Commerce commerce = ValidationUtils.validateEntity(commerceRepo.findById(commerceId),"Comercio", commerceId);

        Map<String,Object> cloudinaryResult = cloudinaryService.uploadImage(file, "commerces/cover");

        Image image = new Image();
        image.setUrl((String)cloudinaryResult.get("secure_url"));
        image.setPublicId((String) cloudinaryResult.get("public_id"));
        image.setOriginalFileName(file.getOriginalFilename());
        image.setCommerce(commerce);
        image.setImageType(ImageType.COVER);

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
    public Image getImageById(Long idImage) {
        return ValidationUtils.validateEntity(imageRepo.findById(idImage),"Imagen", idImage);
    }

    @Override
    public List<Image> getImagesByCommerce(Long idCommerce) {
        Commerce commerce = ValidationUtils.validateEntity(commerceRepo.findById(idCommerce), "Comercio", idCommerce);
        return imageRepo.findByCommerceOrderByImageOrder(commerce);
    }

    @Override
    public List<Image> getImagesByEvent(Long idEvent) {
        Event event = ValidationUtils.validateEntity(eventRepo.findById(idEvent), "Evento", idEvent);
        return imageRepo.findByEventOrderByImageOrder(event);
    }

    @Override
    public List<Image> getImagesByPost(Long idPost) {
        Post post = ValidationUtils.validateEntity(postRepo.findById(idPost), "Publicación", idPost);
        return imageRepo.findByPostOrderByImageOrder(post);
    }
}




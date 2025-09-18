package com.example.dondeQueda.services;

import com.example.dondeQueda.dtos.ImageDto;
import com.example.dondeQueda.models.Commerce;
import com.example.dondeQueda.models.Event;
import com.example.dondeQueda.models.Image;
import com.example.dondeQueda.models.Post;
import com.example.dondeQueda.repositories.IImageRepository;
import com.example.dondeQueda.services.interfaces.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService implements IImageService {

    @Autowired
    private IImageRepository imageRepo;
    @Autowired
    private EntityValidatorService validatorService;

    @Override
    public String saveImgage(ImageDto imageDto) {

        Image image = new Image();

        image.setUrl(imageDto.getUrl());
        image.setImageType(imageDto.getImageType());

        imageRepo.save(image);

        return "Imagen guardada correctamente.";
    }

    @Override
    public List<Image> getImages() {
        return imageRepo.findAll();
    }

    @Override
    public Image getImageById(Long idImage) {
        return validatorService.validateImage(idImage);
    }

    @Override
    public String editImage(Long idImage, ImageDto imageDto) {

        Image image = validatorService.validateImage(idImage);

        image.setUrl(imageDto.getUrl());
        image.setImageType(imageDto.getImageType());

        imageRepo.save(image);

        return "Imagen editada correctamente.";
    }

    @Override
    public String deleteImageById(Long idImage) {

        Image image = validatorService.validateImage(idImage);
        imageRepo.delete(image);

        return "Imagen eliminada correctamete.";
    }

    @Override
    public List<Image> getImagesByCommerce(Long idCommerce) {

        Commerce commerce = validatorService.validateCommerce(idCommerce);
        return imageRepo.findByCommerceOrderByImageOrder(commerce);
    }

    @Override
    public List<Image> getImagesByEvent(Long idEvent) {

        Event event = validatorService.validateEvent(idEvent);
        return imageRepo.findByEventOrderByImageOrder(event);
    }

    @Override
    public List<Image> getImagesByPost(Long idPost) {

        Post post = validatorService.validatePost(idPost);
        return imageRepo.findByPostOrderByImageOrder(post);
    }


}
